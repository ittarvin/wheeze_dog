package cn.zjcw.zipkin.file.config;

import cn.zjcw.zipkin.file.boot.TraceFilePropertySourcesConstants;
import cn.zjcw.zipkin.file.sender.FileSender;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zipkin2.Span;
import zipkin2.reporter.AsyncReporter;
import zipkin2.reporter.Reporter;

@Configuration
@ConditionalOnProperty({
        TraceFilePropertySourcesConstants.ZIPKIN_FILE_BOOTSTRAP_ENABLED})
public class FileConfig {


    @Bean(TraceFilePropertySourcesConstants.REPORTER_BEAN_NAME)
    Reporter<Span> myReporter() {
        return AsyncReporter.create(fileSender());
    }

    @Bean(TraceFilePropertySourcesConstants.SENDER_BEAN_NAME)
    FileSender fileSender() {
        return new FileSender();
    }


}
