import java.net.Socket;
import java.util.Scanner;
import java.io.OutputStream;
import java.io.DataOutputStream;

public class client
{
   public static void main(String args[]) throws Exception
   {
	   User user = new User("talha", "/***/");
	   user.sendMessages("hi I am talha");
  }
}
