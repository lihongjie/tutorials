package org.apache.http.examples.client;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * This example demonstrates how to abort an HTTP method before its normal completion.
 */
public class ClientAbortMethod {

    public final static void main(String[] args) throws Exception {
        System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http.impl.conn", "DEBUG");
        System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http.impl.client", "DEBUG");
        System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http.client", "DEBUG");
        System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http", "DEBUG");
        CloseableHttpClient httpclient = HttpClients.createDefault();
//        String url = "http://api.qixin.com/APITestService/enterprise/getDetailAndContactByName?appkey=ada44bd0070711e6b8a865678b483fde&keyword=小米科技有限责任公司";
        String url = "http://www.baidu.com";
        try {
//            HttpGet httpget = new HttpGet("http://httpbin.org/get");
            HttpGet httpget = new HttpGet(url);
            System.out.println("Executing request " + httpget.getURI());
            CloseableHttpResponse response = httpclient.execute(httpget);
            try {
                System.out.println("----------------------------------------");
                System.out.println(EntityUtils.toString(response.getEntity()));
                System.out.println(response.getStatusLine());
                // Do not feel like reading the response body
                // Call abort on the request object
                httpget.abort();
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }
    }

}
