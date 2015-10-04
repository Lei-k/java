import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DaytimeServer {
	
	public final static int PORT = 1050;
	
	public static void main(String[] args){
		try(ServerSocket server = new ServerSocket(PORT)){
			while(true){
				try(Socket connection = server.accept()){
					Writer out = new OutputStreamWriter(connection.getOutputStream());
					Date now = new Date();
					out.write(now.toString() + "\r\n");
					out.flush();
					connection.close();
					System.out.println("Already send the current time to " + connection.toString());
				}catch(IOException ex){}
			}
		}catch(IOException ex){
			System.err.println(ex);
		}
	}
}
