package org.crazyit.cloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Scanner;

/**
 * @Author: xyy
 * @Date: 2020/1/3 9:21
 */
@SpringBootApplication
@EnableEurekaServer
public class FirstServer {
    public static void main(String[] args) {
        // 读取控制台输入，决定使用哪个 profiles
//        Scanner scanner = new Scanner(System.in);
//        String profiles = scanner.nextLine();
//        new SpringApplicationBuilder(FirstServer.class).profiles(profiles)
//                .run(args);
        ConfigurableApplicationContext context1 =
                new SpringApplicationBuilder(FirstServer.class).properties(
                        "spring.config.location=classpath:/application.yml")
                        .properties("spring.profiles.active=slave1").run(args);
        // 启动第二个 Spring 容器
        ConfigurableApplicationContext context2 =
                new SpringApplicationBuilder(FirstServer.class).properties(
                        "spring.config.location=classpath:/application.yml")
                        .properties("spring.profiles.active=slave2").properties("server.port=8081").run(args);
    }
}
