import java.net.*;
import java.io.*;
public class MainServer {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ServerSocket server = new ServerSocket(8000);
		while (true) {
			Socket s = server.accept();	
			Server t = new Server(s);
			t.start();

		}

			
		}

}
