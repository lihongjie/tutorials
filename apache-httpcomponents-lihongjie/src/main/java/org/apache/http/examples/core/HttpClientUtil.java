package org.apache.http.examples.core;

import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

/**
 * https://hc.apache.org/httpcomponents-client-ga/tutorial/html/connmgmt.html
 */
public class HttpClientUtil {

    private static final CloseableHttpClient httpClient = getClosableHttpClient();

    public static final RequestConfig defaultRequestConfig = RequestConfig.custom()
            .setSocketTimeout(30000)
            .setConnectTimeout(30000)
            .setConnectionRequestTimeout(30000)
            .setContentCompressionEnabled(true)
            .setCookieSpec(CookieSpecs.IGNORE_COOKIES)
            .build();

    public static final CloseableHttpClient getClosableHttpClient() {
        return HttpClients.custom()
                .useSystemProperties()
                .setConnectionManager(getConnectionManager())
                .setDefaultRequestConfig(defaultRequestConfig)
                .setMaxConnPerRoute(200)
                .setMaxConnTotal(500)
                .build();

    }

    /**
     * PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
     // Increase max total connection to 200
     cm.setMaxTotal(200);
     // Increase default max connection per route to 20
     cm.setDefaultMaxPerRoute(20);
     // Increase max connections for localhost:80 to 50
     HttpHost localhost = new HttpHost("locahost", 80);
     cm.setMaxPerRoute(new HttpRoute(localhost), 50);

     CloseableHttpClient httpClient = HttpClients.custom()
     .setConnectionManager(cm)
     .build();
     * @return
     */

    public static final PoolingHttpClientConnectionManager getConnectionManager() {
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(2000);
        cm.setDefaultMaxPerRoute(200);
        return cm;
    }



}
