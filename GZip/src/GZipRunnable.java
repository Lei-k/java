import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

public class GZipRunnable implements Runnable{
	
	private final File input;
	
	public GZipRunnable(File input){
		this.input = input;
	}
	
	@Override
	public void run(){
		//不要壓縮已經壓縮過的檔案
		if(!input.getName().endsWith(".gz")){
			File output = new File(input.getParent(), input.getName() + ".gz");
			if(!output.exists()){ //不要複寫已經存在的檔案
				try(//需要Java7有資源宣告的try語法
						InputStream in = new BufferedInputStream(new FileInputStream(input));
						OutputStream out = new BufferedOutputStream(
						new GZIPOutputStream(new FileOutputStream(output)));
				){
					int b;
					while((b = in.read()) != -1) out.write(b);
					out.flush();
					System.out.println(output + " is complete.");
				}catch(IOException ex){
					System.err.println(ex);
			    }
			}
		}
	}
}
