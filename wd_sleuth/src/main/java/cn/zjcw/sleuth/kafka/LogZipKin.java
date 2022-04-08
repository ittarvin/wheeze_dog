package cn.zjcw.sleuth.kafka;


import cn.zjwc.structlog4j.ILogger;
import cn.zjwc.structlog4j.SLoggerFactory;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


/**
 *
 */
@Component
public class LogZipKin {

    private ILogger log = SLoggerFactory.getLogger(LogZipKin.class);

    @KafkaListener(topics = "wd_sleuth_server",groupId = "wpf12")
    public void listen(ConsumerRecord<?, ?> cr) throws Exception {

        //log.info("------------>","value",cr.value());
        System.out.println("---------------------------------------");
        System.out.println(cr.value().toString());
        System.out.println("--l-------------------------------------");

    }


}
