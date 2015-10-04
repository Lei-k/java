import java.net.InetAddress;
import java.net.UnknownHostException;

public class GetByAddress {
	public static void main(String[] args){
		byte[] address = {(byte)192,(byte) 168, 43, 69};
		try {
			InetAddress lessWrong = InetAddress.getByAddress(address);
			System.out.println(lessWrong);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
