import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;

public class SourceViewer {
	public static void main(String[] args){
		try{
			//開啟URL供讀取
			URL u = new URL(args[0]);
			//以緩衝提昇效能
			try(InputStream in = new BufferedInputStream(u.openStream())){
				//將InputStream與Reader串接
				Reader r = new InputStreamReader(in);
				int c = 0;
				while((c = r.read()) != -1) System.out.print((char)c);
			}
		}catch(IOException ex){
			System.err.println(ex);
		}
	}
}
