import java.net.InetAddress;
import java.net.UnknownHostException;

public class OReillyByName {
	
	public static void main(String[] args){
		try{
			InetAddress[] addresses = InetAddress.getAllByName(args[0]);
			for(InetAddress address : addresses){
			    System.out.println(address);
			}
		}catch(UnknownHostException ex){
			System.out.println("Could not find " + args[0]);
		}
	}
}
