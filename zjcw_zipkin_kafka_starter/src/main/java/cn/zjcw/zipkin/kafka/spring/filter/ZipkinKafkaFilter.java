package cn.zjcw.zipkin.kafka.spring.filter;

import brave.Span;
import brave.Tracer;
import cn.zjcw.zipkin.kafka.spring.config.ZipkinKafkaApplicationProperties;
import cn.zjcw.zipkin.kafka.spring.config.ZipkinKafkaPropertySourcesConstants;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.sleuth.instrument.web.TraceWebServletAutoConfiguration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@Component
@Order(TraceWebServletAutoConfiguration.TRACING_FILTER_ORDER + 1)
@ConditionalOnProperty({
        ZipkinKafkaPropertySourcesConstants.ZIPKIN_KAFKA_TAGS_ENABLED})
public class ZipkinKafkaFilter extends GenericFilterBean {

    private static final Logger logger = LoggerFactory.getLogger(ZipkinKafkaFilter.class);


    private final Tracer tracer;

    @Autowired
    ZipkinKafkaApplicationProperties zipkinKafkaApplicationProperties;

    ZipkinKafkaFilter(Tracer tracer) {
        this.tracer = tracer;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        Span currentSpan = this.tracer.currentSpan();

        if (currentSpan == null) {
            chain.doFilter(request, response);
            return;
        }

        if(zipkinKafkaApplicationProperties.getTags() == null){
            chain.doFilter(request, response);
            return;
        }

        try {

            // for readability we're returning trace id in a hex form
            ((HttpServletResponse) response).addHeader("ZIPKIN-TRACE-ID",
                    currentSpan.context().traceIdString());

            String tagsJsonStr = zipkinKafkaApplicationProperties.getTags();

            JSONObject obj = JSONObject.parseObject(tagsJsonStr);

            // we can also add some custom tags
            Set<String> keys = obj.keySet();

            keys.forEach(key->currentSpan.tag(key,String.valueOf(obj.get(key))));

        }catch (Exception e){

            logger.error("Zipkin 2 Kafka add tags Exception {}", e);

        }finally {
            chain.doFilter(request, response);
        }
    }


}
