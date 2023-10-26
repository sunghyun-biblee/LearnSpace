package com.test02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MyServer {
//	UDP 통신
	public static void main(String[] args) throws IOException {
//		소켓생성
		DatagramSocket ds = new DatagramSocket();
		System.out.println("서버 입니다.");
//		보낼 data
		byte buff[] = "연습입니다.".getBytes();

//		packet으로 감싼다.(data,주소,포트)
		DatagramPacket sendp = new DatagramPacket(buff, buff.length, InetAddress.getByName("localhost"), 9999);
//		보낸다
		ds.send(sendp);

//		종료
		ds.close();
		ds.disconnect();
	}

}
