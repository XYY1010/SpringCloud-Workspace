package org.crazyit.cloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.Scanner;

/**
 * @Author: xyy
 * @Date: 2020/1/3 10:18
 */
@SpringBootApplication
@EnableEurekaClient
public class FirstServiceProvider {
    public static void main(String[] args) {
        // 读取控制台输入的端口，避免端口冲突
        Scanner scanner = new Scanner(System.in);
        String port = scanner.nextLine();
        new SpringApplicationBuilder(FirstServiceProvider.class).properties(
                "service.port=" + port).run(args);
    }
}
