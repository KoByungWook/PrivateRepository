package http.exam01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;

public class httpGetClient {

    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();	//4.5버전에서 httpClient 만드는 방법
        try {
			URIBuilder uriBuilder = new URIBuilder("http://192.168.3.138:8080/IoTWebProgramming/http/exam01");
			uriBuilder.setParameter("thermistor", String.valueOf(25));
			uriBuilder.setParameter("photoresistor", String.valueOf(200));
			
            HttpGet httpGet = new HttpGet(uriBuilder.build());
			
            CloseableHttpResponse response = httpClient.execute(httpGet);		//Get방식으로 보내는 방법, Post 방식은 get을 post로만 바꿔주면됌 // 동기방식
            try {
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    InputStream is = resEntity.getContent();
                    try {
                        InputStreamReader isr = new InputStreamReader(is);
                        BufferedReader br = new BufferedReader(isr);
                        String json = "";
                        while(true) {
                            String data = br.readLine();	//버퍼를 사용해야 사용할 수 있다.
                            if(data == null) break;
                            json += data;
                        }
                        JSONObject jsonObject = new JSONObject(json);	//얻어온 문자열을 파싱
						
                        Double thermistor = jsonObject.getDouble("thermistor");
						Double photoresistor = jsonObject.getDouble("photoresistor");
						 
                        System.out.println("thermistor: " + thermistor);
						System.out.println("photoresistor: " + photoresistor);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        is.close();
                    }
                }
            } finally {
                response.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            httpClient.close();
        }
    }
}
