import java.io.IOException; 
import org.apache.commons.httpclient.*; 
import org.apache.commons.httpclient.methods.*; 

public class SimpleClient { 
    public static void main(String[] args) throws IOException { 
        HttpClient client = new HttpClient(); 
        // 設置代理服務器地址和端口       

        //client.getHostConfiguration().setProxy("proxy_host_addr",proxy_port); 
        // 使用 GET 方法 ，如果服務器需要通過 HTTPS 連接，那只需要將下面 URL 中的 http 換成 https 
        HttpMethod method = new GetMethod("http://www.mail.ntust.com"); 
        //使用POST方法 
        //HttpMethod method = new PostMethod("http://java.sun.com"); 
        client.executeMethod(method); 

        //打印服務器返回的狀態 
        System.out.println(method.getStatusLine()); 
        //打印返回的信息 
        System.out.println(method.getResponseBodyAsString()); 
        //釋放連接 
        method.releaseConnection(); 
    } 
} 
