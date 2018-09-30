package org.apache.http.examples.test;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.entity.BasicHttpEntity;

import java.util.HashMap;
import java.util.Map;

public class BaiRongTest {

    public static void main(String[] args) throws Exception {

        HttpClient httpClient = HttpsUtils.getHttpClient();
        String url = "https://api.100credit.cn/KeyAttribution";

        HttpEntity httpEntity = new BasicHttpEntity();
        Map<String, String> param = new HashMap<>();
        param.put("id", "510182199203191611");
        param.put("cell", "18708154351");
        param.put("name", "李洪杰");
        HttpsUtils.post(url, null, param, null);
    }
}
