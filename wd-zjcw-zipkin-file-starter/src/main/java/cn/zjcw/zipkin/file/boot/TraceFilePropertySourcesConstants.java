
package cn.zjcw.zipkin.file.boot;

/**
 * 插件使用配置常量
 * @author Arvin
 * @since  2022-04-13
 */
public interface TraceFilePropertySourcesConstants {


  /**
   * 插件配置
   */
   String ZIPKIN_FILE_BOOTSTRAP_ENABLED = "cn.zjcw.zipkin.file.enabled";

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
