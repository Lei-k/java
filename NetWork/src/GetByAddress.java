import java.net.InetAddress;
import java.net.UnknownHostException;

public class GetByAddress {
	public static void main(String[] args){
		byte[] address = {107, 23, (byte) 216, (byte) 195};
		try {
			InetAddress lessWrong = InetAddress.getByAddress(address);
			System.out.println(lessWrong);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
