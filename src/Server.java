import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread{


	private Socket s;

	Server(Socket s){
		this.s = s;
	}

	public void run(){
		try {
			BufferedReader fileName = new BufferedReader(
				new InputStreamReader(s.getInputStream()));
			String file = fileName.readLine();

			FileInputStream fileSocket = new FileInputStream("./Files/"+file);
			OutputStream socketClient = s.getOutputStream();
			byte[] cbuffer = new byte[1024];
			int byteRead;

			while ((byteRead = fileSocket.read(cbuffer)) != -1) {
				socketClient.write(cbuffer,0,byteRead);
				socketClient.flush();
			}

			socketClient.close();
			fileSocket.close();

			System.out.println("fineshed");


		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
