package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpHeaders;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.AbstractHttpMessage;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import play.api.Play;



public class HttpUtils {
	
	public static Integer CONNECTION_TIME_OUT = 930000;
	public static final String CONTENT_TYPE = "Content-Type";
	public static final String RESPONSE_ATTRIB_NAME = "response";
	public static final String HTTP_STATUS_CODE_ATTRIB_NAME = "httpStatusCode";
	
	  
	  public static Map<String,String> executeGet(String url,Map<String,String> queryParams,Map<String,String> headers,String charset,
	          Integer requestTimeout) throws ClientProtocolException, IOException{
	    Map<String,String> node=null;
	    CloseableHttpResponse response=null;
	    HttpGet get=null;
	    CloseableHttpClient httpClient = getHttpClient();
	    try{
	      String completeUrl = url+getQueryParamString(queryParams,charset);
	      get = new HttpGet(completeUrl);
	      addHeaders(get,headers);
	      RequestConfig requestConfig = RequestConfig.custom()
	              .setSocketTimeout(requestTimeout)
	              .setConnectTimeout(CONNECTION_TIME_OUT)
	              .build();
	      get.setConfig(requestConfig);
	      response = httpClient.execute(get);
	      node = processGetResponse(response);
	    } catch (Exception e) {
	      play.Logger.error("Error executing get ", e);
	    } finally {
	      closeAll(response, get, httpClient);
	    }
	    return node;
	  }
	  
	  private static Map<String,String> processGetResponse(CloseableHttpResponse response) throws ParseException, IOException {
		    InputStreamReader isReader = null;
		    BufferedReader buffReader = null;
		    StringBuilder sb  = new StringBuilder();
		    try {
		      isReader = new InputStreamReader(response.getEntity().getContent());
		      buffReader = new BufferedReader(isReader);
		      String line;
		      while ((line = buffReader.readLine()) != null) {
		        sb.append(line);
		      }
		    } finally {
		      closeStreamReader(buffReader);
		      closeStreamReader(isReader);
		    }
		    Integer responseCode = response.getStatusLine().getStatusCode();
		    Map<String,String> node = new HashMap<>();
		    node.put(HTTP_STATUS_CODE_ATTRIB_NAME, responseCode.toString());
		    node.put(RESPONSE_ATTRIB_NAME, sb.toString());
		    EntityUtils.consumeQuietly(response.getEntity());
		    return node;
		  }
	  
	  
	  public static CloseableHttpClient getHttpClient() {
		    return HttpClients.createDefault();
		  }
	  
	  private static String getQueryParamString(Map<String, String> queryParams, String charset)
	          throws UnsupportedEncodingException {
	    StringBuilder builder = new StringBuilder();
	    if (null != queryParams && queryParams.size() > 0) {
	      builder.append("?");
	      for (Map.Entry<String, String> entry : queryParams.entrySet()) {
	        builder.append(entry.getKey()).append("=")
	                .append(URLEncoder.encode(entry.getValue(), charset)).append("&");
	      }
	      return builder.substring(0, builder.length() - 1);
	    }
	    return "";
	  }
	  
	  private static void addHeaders(AbstractHttpMessage message, Map<String, String> headers) {
		    if (null != headers && headers.size() > 0) {
		      for (Map.Entry<String, String> header : headers.entrySet()) {
		        message.addHeader(header.getKey(), header.getValue());
		      }
		      if (!headers.containsKey(HttpHeaders.CONTENT_TYPE)) {
		        message.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
		      }
		    } else {
		      message.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
		    }
	}
	  
	  public static void closeStreamReader(Reader reader){
		    if (reader != null){
		      
		      try{
		        reader.close();
		      }
		      catch(Exception e){
		        
		      }
		    }
		  }
	  
	  public static void closeAll(CloseableHttpResponse response, HttpRequestBase post,
	          CloseableHttpClient httpClient) {
	    closeHttpResponse(response);
	    closeHttpRequest(post);
	    closeHttpConnection(httpClient);
	  }
	  
	  public static void closeHttpResponse(CloseableHttpResponse response) {
		    if (null != response) {
		      try {
		        response.close();
		      } catch (Exception e) {
		        play.Logger.error("Error Closing httpResponse ", e);
		      }
		    }
		  }
	  
	  public static void closeHttpConnection(CloseableHttpClient client){
		    if(null!=client){
		      try{
		        client.close();
		      } catch (Exception e) {
		        play.Logger.error("Error Closing httpClient ", e);
		      }
		    }
		  }
	  public static void closeHttpRequest(HttpRequestBase request) {
		    if (null != request) {
		      try {
		        request.releaseConnection();
		      } catch (Exception e) {
		        play.Logger.error("Error Closing httpResponse ", e);
		      }
		    }
		  }
}
