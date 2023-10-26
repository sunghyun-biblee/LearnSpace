package com.test03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
//	TCP
	public static void main(String[] args) {
//		준비 - 변수 생성
		ServerSocket serverSocket = null; // 클라이언트로 부터 들어오는 연결요청 받는 소켓
		Socket serviceSocket = null; // 연결요청 수락 후 클라이언트와 연결하기 위한 소켓

//		출력개체
		PrintWriter out = null;
//		입력개체
		BufferedReader in = null;

		try {
			serverSocket = new ServerSocket(9998);
		} catch (IOException e) {
			e.printStackTrace();
		}

		while (true) {
			System.out.println("client를 기다립니다.");
			try {
				serviceSocket = serverSocket.accept();
				System.out.println("client가 접속했습니다.");

//				1. client에게 받은 내용을 라인 단위로 읽는다
				in = new BufferedReader(new InputStreamReader(serviceSocket.getInputStream()));

//				2. 받은 내용을 다시 보내준다
				out = new PrintWriter(serviceSocket.getOutputStream(), true);

				String inputLine = null;
				while ((inputLine = in.readLine()) != null) {
					System.out.println("클라이언트가 보낸 메시지 : " + inputLine);
					out.println("[서버가 다시 보낸 메시지] " + inputLine);
				}

				out.close();
				in.close();
				serviceSocket.close();
				serverSocket.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
