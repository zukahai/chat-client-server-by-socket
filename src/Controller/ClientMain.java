package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import View.Client_GUI;

public class ClientMain extends Thread{
	DataInputStream dataInputStream = null;
	DataOutputStream dataOutputStream = null;
	Client_GUI ClientGUI = null;
	public ClientMain(String ip, int port, String name) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		Socket socket = new Socket(ip, port);
		dataInputStream = new DataInputStream(socket.getInputStream());
		dataOutputStream = new DataOutputStream(socket.getOutputStream());
		
		ClientGUI = new Client_GUI(name, ip, port);
		ClientGUI.send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = name + ": " + ClientGUI.textField.getText();
				try {
					dataOutputStream.writeUTF(str);
					dataOutputStream.flush();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ClientGUI.textField.setText("");
			}
		});
	}
	public void run() {
		while (true) {
			String str2 = "";
			try {
				while((str2 = dataInputStream.readUTF()) != null) {
					System.out.println(str2);
					ClientGUI.textArea.setText(ClientGUI.textArea.getText() + str2 + "\n");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
;		}
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		new ClientMain("localhost", 3333, "Hai").start();
	}

}
