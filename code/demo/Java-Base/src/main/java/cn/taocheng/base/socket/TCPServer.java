package cn.taocheng.base.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket clientSocket = null;
		int port = 9001;
		try {
			serverSocket = new ServerSocket(port);
			System.out.println("init server");
			clientSocket = serverSocket.accept();
			InputStream in = clientSocket.getInputStream();
			byte[] data = new byte[5];
			StringBuilder sb = new StringBuilder();
			while (in.read(data) != -1) {
				sb.append(new String(data));
			}
			System.out.println(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
