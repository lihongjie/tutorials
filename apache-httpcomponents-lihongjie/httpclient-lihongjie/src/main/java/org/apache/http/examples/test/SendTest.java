package org.apache.http.examples.test;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SendTest {

	private static final ObjectMapper objectMapper = new ObjectMapper();

	public static void main(String[] args) throws JsonProcessingException {
		// TODO Auto-generated method stub
		HttpUtilTest test = new HttpUtilTest();

		//登陆专用url
//		String url = "https://api.100credit.cn/bankServer2/user/login.action";
		String url = "https://api.100credit.cn/bankServer2/data/terData.action";
//		String url = "https://api.100credit.cn/KeyAttribution";
//		String params = "userName=cgnbstr&password=cgnbstr&apiCode=3001266";
//		String params = "id=510182199203191611&name=李洪杰&cell=18708154351";
		KeyAttribution keyAttribution = new KeyAttribution();
		keyAttribution.setId("510182199203191611");
		keyAttribution.setName("李洪杰");
		keyAttribution.setCell("18708154351");
		String paramsNew = objectMapper.writeValueAsString(keyAttribution);

		String tokenId = "cgnbstr_B68A1BCF89E4727163C149C211FD2E77";
		String checkCode = MD5Utils.genMd5(paramsNew + MD5Utils.genMd5("3001266" + tokenId));
		String params = "apiCode=3001266&tokenid=" + tokenId + "&checkCode=" + checkCode +"&jsonData=" + paramsNew;
		try {

//			try {

				String str = test.sendPost(url, params);
				System.out.println(str);
//				JSONObject jsonObject = JSONObject.fromObject(test.sendPost(url, Params));
//				Iterator<?> it = jsonObject.keys();
//
//				if(it.hasNext()) {
//
//					code = jsonObject.get(it.next()).toString();
//					System.out.println(code);
//					if(code.equals("00")) {
//
//						tokenid = jsonObject.get(it.next()).toString();
//						System.out.println(tokenid);
//
//
//						String jsonData = "{\"meal\":\"SpecialList_c\",\"id\":\"210381198301222732\",\"cell\":\"13321183623\",\"name\":\"测试\"}";
//
//
//						String checkCode = MD5Utils.genMd5(jsonData+MD5Utils.genMd5(("apiCode"+tokenid)));
//
//						//url = "https://api.100credit.cn/HainaApi/data/getData.action";//海纳
//						//url = "https://api.100credit.cn/huaxiang/v1/get_report";//画像
//						url = "https://api.100credit.cn/trinity_force/v1/get_data";//整合
//						//url = "https://api.100credit.cn/huaxiang/v1/get_report";
//						//url = "https://api.100credit.cn/huaxiang/v1/get_report";
//
//
//						Params = "tokenid="+tokenid+"&apiCode="+apiCode+"&jsonData="+jsonData+"&checkCode="+checkCode;
//
//						System.out.println(Params);
//
//						jsonObject = JSONObject.fromObject(test.sendPost(url, Params));
//						it = jsonObject.keys();
//
//						while(it.hasNext()) {
//
//							System.out.println(jsonObject.get(it.next()));
//
//						}
//
//					}

//				}
				


//			} catch (JSONException e) {
//
//				e.printStackTrace();

//			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
