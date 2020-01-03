package org.crazyit.cloud;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: xyy
 * @Date: 2020/1/3 10:39
 */
@RestController
@Configuration
public class InvokerController {
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @RequestMapping(value = "/router", method = RequestMethod.GET, produces =
            MediaType.APPLICATION_JSON_VALUE)
    public String router() {
        RestTemplate resTpl = getRestTemplate();
        // 根据应用名称调用服务
        String json = resTpl.getForObject("http://first-cloud-provider/person" +
                "/1", String.class);
        return json;
    }
}
