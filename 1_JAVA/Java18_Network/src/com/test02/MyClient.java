package com.test02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class MyClient {
	public static void main(String[] args) throws IOException {
//		소켓생성
		DatagramSocket ds = new DatagramSocket(9999);
		System.out.println("클라이언트");

//		데이터 받을 배열 생성
		byte buff[] = new byte[1024];

		DatagramPacket recievep = new DatagramPacket(buff, buff.length);

//		서버에서 send한 packet 저장
		ds.receive(recievep);
		System.out.println(new String(recievep.getData()));

//		종료
		ds.close();
		ds.disconnect();
	}
}
