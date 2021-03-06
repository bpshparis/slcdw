package com.bpshparis.wsvc.app0;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.visual_recognition.v3.model.ClassifiedImages;
import com.ibm.watson.visual_recognition.v3.model.ClassifyOptions;

public class Main0 {

	public static void main(String[] args) throws IOException, NoSuchAlgorithmException, KeyManagementException {
		// TODO Auto-generated method stub
		
//		String version = "2018-03-19";
//		String password = "iL7mtf3ebj1DI7-DPFYZ6CXaWcq726dINi68Dw8JUz1o";
//		String password = "oaKhuzPMVbhZuKv6IQx5ZHliR27SM0kI1bec7SCK1kVB";
//		String username = "apikey";
//		String password = "YydUT91iEMdi7hQ8I5EVpWt8sMrwhAbMGJfvihTWITAq";
//		String password = "c837b42bc182da29aa29e2647752f88492089ea2";
//		String password = "7d613e84233863ce7f62a3a38b14b9653e9c6e34";
//		String password = "aOLM2E2fo5_na5E3SVh_v9s4tpeJebItmp8vnX4U9A4H";
//		String password = "fP1J2DKzexDK4pFB7ByaXcBZ9nhKTTSrATD9Aqu6X2Mg";
//		String password = "0qegHj7E4KQFokkUGA_0Y0oNrXeT3W4TFr6MCoB_EbMe";
//		String password = "3_QCFqpyW6ZcSmnpbY3uRqBIC6KgxxTYGhxPIR1kZKeX";
//		String url = "http://172.16.186.244/dma/TestDBConnection";
//		String url = "https://gateway.watsonplatform.net/visual-recognition/api/v3/classify?version=2018-03-19";
//		String url = "https://gateway-a.watsonplatform.net/visual-recognition/api/v3/classify?version=2018-03-19";
//		String url = "https://gateway-a.watsonplatform.net/visual-recognition/api";
//		String url = "https://gateway.watsonplatform.net/visual-recognition/api";
//		String query = "/visual-recognition/api/v3/classify?version=2018-03-19";
//		Path path = Paths.get("/opt/wks/ma/WebContent/res/mails/pic0.jpg");
		
//	    OkHttpClient client = new UnsafeOkHttpClient().getUnsafeOkHttpClient();
//	    
//	    OkHttpClient client = new OkHttpClient.Builder().build();
	    
//		client = client.newBuilder()
//	    	.addInterceptor(new BasicAuthInterceptor(username, password))
//	    	.build();		
//	    
//		RequestBody body = new MultipartBody.Builder()
//				.setType(MultipartBody.FORM)
//	            .addFormDataPart("File", "images_file", RequestBody.create(MediaType.parse("image/jpeg"),path.toFile()))
//	            .build();
//
//	    Request request = new Request.Builder()
//	    		.url(url)
//	    		.post(body)
//	    		.build();
//	    
//	    Response response = client.newCall(request).execute();
//	    String result = response.body().string();
//	    System.out.println("result=" + result);
//	    
//	    
//	    InputStream is = new ByteArrayInputStream(result.getBytes(StandardCharsets.UTF_8.name()));
//		
//		InputStreamReader isr = new InputStreamReader(is);
//		BufferedReader br = new BufferedReader(isr);
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
//        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
//        Map<String, Object> svc = mapper.readValue(br, new TypeReference<Map<String, Object>>(){});
//        
//        List<Object> images = (List<Object>) svc.get("images");
//		
//		Map<String, Object> images0 = (Map<String, Object>) images.get(0);
//		
//		List<Object> classifiers = (List<Object>) images0.get("classifiers");
//		
//		if(classifiers != null){
//		
//			Map<String, Object> classifiers0 = (Map<String, Object>) classifiers.get(0);
//			
//			String json = mapper.writeValueAsString(classifiers0.get("classes"));
//			
//			List<VRClass> classes = Arrays.asList(mapper.readValue(json, VRClass[].class));
//			
//			for(VRClass vrClass: classes){
//				System.out.println(vrClass.getVrClass() + " -> " + vrClass.getScore());
//			}
//			
//			
//		}	    
		    
		
		String version = "2018-03-19";
//		String username = "apikey";
		String password = "3_QCFqpyW6ZcSmnpbY3uRqBIC6KgxxTYGhxPIR1kZKeX";
		String url = "https://gateway.watsonplatform.net/visual-recognition/api";
		Path path = Paths.get("/home/fr054721/slcdw/image0.jpg");
		
		Authenticator authenticator = new IamAuthenticator(password);
		com.ibm.watson.visual_recognition.v3.VisualRecognition service = new VisualRecognition(version, authenticator);
		service.setServiceUrl(url);

		System.out.println("Classify an image");
		ClassifyOptions options = new ClassifyOptions.Builder()
		  .imagesFile(path.toFile()) // replace with path to file
		  .build();
		ClassifiedImages result = service.classify(options).execute().getResult();
		System.out.println(result);
		
		
	}

}
