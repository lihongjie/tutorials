package com.example;

import com.example.util.HttpClientUtil;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@SpringBootApplication
@RestController
public class DemoApplication {

	private static final CloseableHttpClient httpClient = HttpClientUtil.getClosableHttpClient();

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@RequestMapping(value = "/hello1", method = RequestMethod.GET)
	public ResponseEntity hello() throws IOException {

		for (int i = 0; i < 5; i++) {
			System.out.println(getBaidu());
		}
		return ResponseEntity.ok("123456");
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ResponseEntity test() throws IOException {

		return ResponseEntity.ok("test");
	}


	public static String getBaidu() throws IOException {

		HttpGet httpGet = new HttpGet("http://www.baidu.com");
		CloseableHttpResponse httpResponse = null;
		HttpEntity httpEntity = null;
		String result = null;
		try {
			httpResponse = httpClient.execute(httpGet);
			httpEntity = httpResponse.getEntity();
			result =  EntityUtils.toString(httpEntity);
			EntityUtils.consume(httpEntity);
			return result;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				if (httpResponse != null)
					httpResponse.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return result;
	}



}
