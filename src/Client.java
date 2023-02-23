
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.DatagramSocket;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//Abrir conexao com cliente 
			
			System.out.println("conecceting");
			Socket clienSocket = new Socket("localhost", 8000);
			System.out.println("coneccted");
			DataOutputStream fileSocket = new DataOutputStream(clienSocket.getOutputStream());
			fileSocket.writeBytes("teste.txt" + "\n");

			FileOutputStream outSocket = new FileOutputStream("./Receive_files/receive.txt");

			InputStream inputStream = clienSocket.getInputStream();
			byte[] cbuffer = new byte[1024];
			int byteRead;

			while ((byteRead = inputStream.read(cbuffer))!= -1) {
				outSocket.write(cbuffer,0,byteRead);
			}

			outSocket.close();
			clienSocket.close();
			System.out.println("fineshed");
		

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
