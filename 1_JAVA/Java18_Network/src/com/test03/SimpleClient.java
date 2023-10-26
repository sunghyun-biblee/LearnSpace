package com.test03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SimpleClient {

	public static void main(String[] args) {
//		준비
		Socket clientSocket = null;
		PrintWriter out = null;
		BufferedReader in = null;
		Scanner sc = new Scanner(System.in);

		System.out.println("server에 접속합니다.");
		try {
//			소켓생성, 서버로 연결요청
			clientSocket = new Socket("localhost", 9998);
			
			out = new PrintWriter(clientSocket.getOutputStream(),true);  //출력 스트림
//			기반 스트림 out 이용해 통로만들고
//			보조 스트림인 print로 내용을 보낸다
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); // 입력 스트림
//			기반 스트림 getinput 이용해 통로만들고
//			보조 스트림 inputstreamreader를 이용해 바이트를 문자단위로 변환
//			보조 스트림 bufferedreader로 버퍼에 있는 변환내용을 읽음
			
			String inputLine;
			while((inputLine=sc.nextLine())!=null) {
//				nextline으로 내용을 읽어온다 null값이 나오기전까지
				out.println(inputLine);
			System.out.println("server로부터 다시 받은 메시지 : "+ in.readLine());
			}
			sc.close();
			in.close();
			out.close();
			clientSocket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
