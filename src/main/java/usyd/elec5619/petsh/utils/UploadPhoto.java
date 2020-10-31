package usyd.elec5619.petsh.utils;

import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;

public class UploadPhoto implements Runnable {
    private String url;
    private JSONObject json;

    /**
     *
     * @param json
     * "message": "",
     * "content": "",
     *  commiter:{
     *      "name": "",
     *      "email": ""
     *   }
     */
    public UploadPhoto(JSONObject json,String url) {
        this.json = json;
        this.url = url;
    }

    public void run() {
        String encode = "utf-8";
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        HttpPut httpput = new HttpPut(url);
        httpput.setHeader("Accept", "*/*");
        httpput.setHeader("Accept-Encoding", "gzip, deflate");
        httpput.setHeader("Cache-Control", "no-cache");
        httpput.setHeader("Connection", "keep-alive");
        httpput.setHeader("Content-Type", "application/json;charset=UTF-8");
        StringEntity stringEntity = new StringEntity(json.toJSONString(), encode);
        httpput.setEntity(stringEntity);
        String content = null;
        CloseableHttpResponse httpResponse = null;
        JSONObject json1 = null;
        try {
            httpResponse = closeableHttpClient.execute(httpput);
            HttpEntity entity = httpResponse.getEntity();
            content = EntityUtils.toString(entity, encode);
            json1 = JSONObject.parseObject(content);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                httpResponse.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            closeableHttpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(json1.getJSONObject("content").get("download_url"));
        url=(String) json1.getJSONObject("content").get("download_url");
    }

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}