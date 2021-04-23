package cn.taocheng.base.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("localhost", 9001);
		OutputStream oos = socket.getOutputStream();
		oos.write("123459999".getBytes());
		oos.close();
	}
}
