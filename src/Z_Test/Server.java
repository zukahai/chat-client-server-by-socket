package Z_Test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket svs = new ServerSocket(3333);
		Socket s = svs.accept();
		DataInputStream dis = new DataInputStream(s.getInputStream());
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		while (true) {
			String str = dis.readUTF();
			System.out.println("Client " + str);
			if (str.equals("q"))
				break;
			dos.writeUTF("Sever: " + str);
			dos.flush();
		}
		dis.close();
		dos.close();
		s.close();
	}

}
