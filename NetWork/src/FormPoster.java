import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class FormPoster {
	
	private URL url;
	private QueryString query = new QueryString();
	
	public FormPoster(URL url){
		if(!url.getProtocol().toLowerCase().startsWith("http")){
			throw new IllegalArgumentException("Posting only works for http URLS");
		}
		this.url = url;
	}
	
	public void add(String name, String value){
		query.add(name, value);
	}
	
	public URL getURL(){
		return this.url;
	}
	
	public InputStream post() throws IOException{
		//開啟連線準備POST
		URLConnection uc = url.openConnection();
		uc.setDoOutput(true);
		try(OutputStreamWriter out
				= new OutputStreamWriter(uc.getOutputStream(), "UTF-8")){
			//POST,Content-type,Content-length
			//等標頭由URLConnection發送
			//程式只需要發送資料
			out.write(query.toString());
			out.write("\r\n");
			out.flush();
		}
		
		//回傳回應
		return uc.getInputStream();
	}
	
	public static void main(String[] args){
		URL url;
		if(args.length > 0){
			try{
				url = new URL(args[0]);
			}catch(MalformedURLException ex){
				System.err.println("Usage: java FormPoster url");
				return;
			}
		}else{
			try{
			    url = new URL(
					"http://www.cafeaulait.org/books/jnp4/postquery.phtml");
			}catch(MalformedURLException ex){
				System.err.println(ex);
				return;
			}
		}
		
		FormPoster poster= new FormPoster(url);
		poster.add("USERID", "B10315018");
		poster.add("PASSWD", "mfif322tnu");
		
		try(InputStream in = poster.post()){
			//回傳回應
			Reader r = new InputStreamReader(in);
			int c = 0;
			while((c = r.read()) != -1) System.out.println((char) c);
			System.out.println();
		}catch(IOException ex){
			System.err.println(ex);
		}
	}
}
