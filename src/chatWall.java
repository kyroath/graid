

import java.net.ServerSocket;            
import java.net.Socket;
import java.util.ArrayList;
import java.io.InputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class chatWall // mesajların toplandığı yer burası olacak
{
   
  public static void main() throws IOException {
	     ServerSocket sersock = new ServerSocket(5554); 
	     System.out.println("server is ready");  //  message to know the server is running
	     Socket sock = sersock.accept();                  
	     InputStream istream = sock.getInputStream();  
	     DataInputStream dstream = new DataInputStream(istream);

	     String message2 = dstream.readLine();
	     System.out.println(message2);
	     // save messages to database / arraylist
	     dstream.close(); 
	     istream.close(); 
	     sock.close(); 
	     sersock.close();
  }
}