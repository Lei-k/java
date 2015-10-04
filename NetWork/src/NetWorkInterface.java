import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class NetWorkInterface {
	public static void main(String[] args){
		try {
			InetAddress local = InetAddress.getByName("127.0.0.1");
			NetworkInterface ni = NetworkInterface.getByInetAddress(local);
			if(ni == null){
				System.out.println("That's weird. Could not loopback address.");
				return;
			}else{
				System.out.println(ni);
			}
		} catch (SocketException ex) {
			System.out.println("Could not list sockets.");
		}catch(UnknownHostException ex){
			System.out.println("That's weird. Could not lookup 127.0.0.1");
		}
	}
}
