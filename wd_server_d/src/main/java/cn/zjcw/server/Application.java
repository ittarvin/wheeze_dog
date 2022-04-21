package cn.zjcw.server;


import org.apache.logging.log4j.spi.LoggerContextFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import sun.net.www.protocol.http.HttpURLConnection;

import javax.annotation.PostConstruct;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


@ComponentScan(basePackages = "cn.zjcw")
@SpringBootApplication
public class Application {

    static final String body = "{\n" +
            "    \"name\":\"Test Client\",\n" +
            "    \"param\":\"This project provides an API Gateway built on top of the Spring Ecosystem, including: Spring 5, Spring Boot 2 and Project Reactor. Spring Cloud Gateway aims to provide a simple, yet effective way to route to APIs and provide cross cutting concerns to them such as: security, monitoring/metrics, and resiliency.\"\n" +
            "}";

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class).run(args);
    }

    @PostConstruct
    public void printLogger() throws Exception{

  /*      Executors.newSingleThreadExecutor().submit(() -> {

            System.out.println("Client Request Gateway ");

            while (true) {



                Application.post();

                TimeUnit.MILLISECONDS.sleep(100);

                System.out.print(">");

            }

        });*/

    }


    public static String post(){
        String message="";
        try {
            URL url=new URL("http://172.27.2.141:9000/wdSleuthServerA/a");
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setConnectTimeout(30000);
            connection.setReadTimeout(30000);
            connection.setRequestProperty("Content-type","application/json");
            connection.connect();
            OutputStream outputStream=connection.getOutputStream();
            String param=body;
            outputStream.write(param.getBytes());
            outputStream.flush();
            outputStream.close();
            InputStream inputStream=connection.getInputStream();
            byte[] data=new byte[1024];
            StringBuffer sb1=new StringBuffer();
            int length=0;
            while ((length=inputStream.read(data))!=-1){
                String s=new String(data, Charset.forName("utf-8"));
                sb1.append(s);
            }
            message=sb1.toString();
            inputStream.close();
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return message;
    }
}
