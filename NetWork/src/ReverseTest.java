import java.net.InetAddress;
import java.net.UnknownHostException;

public class ReverseTest {
	public static void main(String[] args) throws UnknownHostException{
		InetAddress ia = InetAddress.getByName("118.214.255.229");
		System.out.println(ia.getCanonicalHostName());
	}
}
