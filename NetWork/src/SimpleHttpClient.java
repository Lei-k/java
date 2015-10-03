import java.io.IOException; 

import org.apache.commons.httpclient.*; 
import org.apache.commons.httpclient.methods.*;

public class SimpleHttpClient { 
   public static void main(String[] args) throws IOException { 
      HttpClient client = new HttpClient(); 
      client.getHostConfiguration().setHost( "www.imobile.com.cn" , 80, "http" ); 
      HttpMethod method = getPostMethod();    // 使用 POST 方式提交數據 
      client.executeMethod(method);   //打印服務器返回的狀態 
      System.out.println(method.getStatusLine());   //打印結果頁面 
      String response = new String(method.getResponseBodyAsString().getBytes("8859_1"));

      //打印返回的信息 
      System.out.println(response); 
      method.releaseConnection(); 
   }
   /** 
    * 使用 GET 方式提交數據 
    
    */ 

   private static HttpMethod getGetMethod(){ 
      return new GetMethod("/simcard.php?simcard=1330227"); 
   } 

    /** 
     * 使用 POST 方式提交數據 
     
     */ 
    private static HttpMethod getPostMethod(){ 
      PostMethod post = new PostMethod( "/simcard.php" ); 
      NameValuePair simcard = new NameValuePair( "simcard" , "1330227" ); 
      post.setRequestBody( new NameValuePair[] { simcard}); 
      return post; 
   } 
} 