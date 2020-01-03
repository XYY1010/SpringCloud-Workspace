package org.crazyit.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: xyy
 * @Date: 2020/1/3 10:39
 */
@SpringBootApplication
@EnableDiscoveryClient
public class FirstInvoker {
    public static void main(String[] args) {
        SpringApplication.run(FirstInvoker.class, args);
    }
}
