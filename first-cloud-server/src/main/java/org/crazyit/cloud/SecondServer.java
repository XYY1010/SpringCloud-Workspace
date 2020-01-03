package org.crazyit.cloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Author: xyy
 * @Date: 2020/1/3 15:09
 */
@SpringBootApplication
@EnableEurekaServer
public class SecondServer {
    public static void main(String[] args) {
        // 启动第二个 Spring 容器
        ConfigurableApplicationContext context2 =
                new SpringApplicationBuilder(SecondServer.class).properties(
                        "spring.config.location=classpath:/application.yml")
                        .properties("spring.profiles.active=slave2").run(args);
    }
}
