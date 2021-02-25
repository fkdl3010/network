package com.koreait.net;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 최초작성자 : 박상길
 * 최초작성일 : 2021-02-25
 * 최종변경일 : 2021-02-25
 * 목적 : 네트워크 프로그래밍 구현
 */

public class MyServer {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("127.0.0.1", 5000));
			while (true) {
				Socket socket = serverSocket.accept();
				InetSocketAddress address = (InetSocketAddress)socket.getRemoteSocketAddress();
				System.out.println("MyServer가 연결되었습니다");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// isSocket을 닫아야 합니다.
			try {
				serverSocket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
