
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.DatagramSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//Abrir conexao com cliente 
			
			System.out.println("conecceting server");
			Socket clientSocket = new Socket("localhost", 8000);
			System.out.println("coneccted");
			DataOutputStream fileSocket = new DataOutputStream(clientSocket.getOutputStream());
			System.out.println("Informe o nome do arquivo");
			Scanner s = new Scanner(System.in);
			String nameFile  = s.nextLine();
			fileSocket.writeBytes(nameFile+".html" + "\n");
			
			clientSocket.setSoTimeout(60000);

			FileOutputStream outSocket = new FileOutputStream("./Receive_files/receive.txt");

			InputStream inputStream = clientSocket.getInputStream();
			byte[] cbuffer = new byte[1024];
			int byteRead;

			while ((byteRead = inputStream.read(cbuffer))!= -1) {
				outSocket.write(cbuffer,0,byteRead);
			}

			outSocket.close();
			clientSocket.close();
			System.out.println("fineshed");
		

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
