package org.crazyit.cloud;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @Author: xyy
 * @Date: 2020/1/3 10:48
 */
public class TestHttpClient {
    public static void main(String[] args) throws Exception {
        // 创建默认的 HttpClient
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 调用 6 次服务并输出结果
        for (int i = 0; i < 6; i++) {
            // 调用 Get 方法请求服务
            HttpGet httpGet = new HttpGet("http://localhost:9000/router");
            // 获取响应
            HttpResponse response = httpClient.execute(httpGet);
            // 根据响应解析出字符串
            System.out.println(EntityUtils.toString(response.getEntity()));
        }
    }
}
