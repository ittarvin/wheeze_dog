
package cn.zjcw.zipkin.kafka.spring.config;

/**
 * 插件使用配置常量
 * @author Arvin
 * @since  2022-04-13
 */
public interface ZipkinKafkaPropertySourcesConstants {


  /**
   * 插件配置
   */
   String ZIPKIN_KAFKA_BOOTSTRAP_ENABLED = "cn.zjcw.zipkin.kafka.enabled";

  /**
   * spring 配置
   */
   String SPRING_ZIPKIN_BOOTSTRAP_ENABLED = "spring.zipkin.enabled";


  /**
   * 自定义tag标签 配置
   */
  String ZIPKIN_KAFKA_TAGS_ENABLED = "cn.zjcw.zipkin.kafka.tags";


  /**
   * 动态日志基本调整
   */
  String ZIPKIN_KAFKA_LOGGER_INFO_ENABLED = "cn.zjcw.dynamic.logger.enabled";


  /**
   * 启动结构化日志JSON格式
   */
  String STRUCT_LOGGER_ENABLED = "cn.zjcw.struct.logger.enabled";


    /**
     * Zipkin reporter bean name. Name of the bean matters for supporting multiple tracing
     * systems.
     */
    String REPORTER_BEAN_NAME = "zipkinReporter";

    /**
     * Zipkin sender bean name. Name of the bean matters for supporting multiple tracing
     * systems.
     */
    String SENDER_BEAN_NAME = "zipkinSender";


}
