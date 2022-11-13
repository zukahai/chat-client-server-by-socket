package Z_Test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		Socket s = new Socket("localhost", 3333);
		DataInputStream dis = new DataInputStream(s.getInputStream());
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		while(true) {
			System.out.println("Input: ");
			Scanner sc = new Scanner(System.in);
			String str = sc.nextLine();
			if (str.equals("q"))
				break;
			dos.writeUTF(str);
			dos.flush();
		}
		dis.close();
		dos.close();
		s.close();
	}

}
