package Controller;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Scanner;

import View.Server_GUI;

public class Server {
	
	
	public Server() throws IOException {
		Server_GUI ServerGUI = new Server_GUI();
		ArrayList<ServerThread> ServerThreadList = new ArrayList<ServerThread>();
		ArrayList<Socket> SocketList = new ArrayList<Socket>();
		ServerSocket serverSocket =  new ServerSocket(3333);
		ServerGUI.textArea.setText(ServerGUI.textArea.getText() + "Server starting.....\n");
		ServerGUI.textArea.setText(ServerGUI.textArea.getText() + "IPv4: " + getIP() + "\n");
		ServerGUI.setTitle("Server - " + getIP());
//		System.out.println("Server khoi dong.....");
		while(true) {
			Socket socket = serverSocket.accept();
//			System.out.println("Ket noi thanh cong");
			ServerGUI.textArea.setText(ServerGUI.textArea.getText() + socket + "\nConnected!\n");
			ServerThread st=new ServerThread(socket, ServerGUI);
			ServerThreadList.add(st);
			SocketList.add(socket);
			for (ServerThread svt : ServerThreadList)
				svt.setSocketList(SocketList);
            st.start();
		}
	}
	public static void main(String[] args) throws IOException {
		new Server();
	}
	
	public String getIP() throws UnknownHostException {
		InetAddress IP=InetAddress.getLocalHost();
		return IP.getHostAddress();
	}
}

class ServerThread extends Thread{  
	ArrayList<Socket> SocketList = new ArrayList<Socket>();
    Socket socket =null;
    Server_GUI ServerGUI;

    public ServerThread(Socket s, Server_GUI ServerGUI){
        this.socket = s;
        this.ServerGUI = ServerGUI;
    }
    
    public void addSocket(Socket socket) {
    	SocketList.add(socket);
    }
    
    public ArrayList<Socket> getSocketList() {
		return SocketList;
	}

	public void setSocketList(ArrayList<Socket> socketList) {
		SocketList = socketList;
	}

	public void run() {
		try {
			DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
			DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
	    	Scanner sc = new Scanner(System.in);
			while(true) {
				String str = dataInputStream.readUTF();
				if (str.equals("Q"))
					break;
				System.out.println("Client: " + str);
				ServerGUI.textArea.setText(ServerGUI.textArea.getText() + str + "\n");
				for (Socket s : SocketList) {
					System.out.println(s);
					dataOutputStream = new DataOutputStream(s.getOutputStream());
					dataOutputStream.writeUTF(str);
					dataOutputStream.flush();
				}
			}
			
			dataInputStream.close();
			dataOutputStream.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
