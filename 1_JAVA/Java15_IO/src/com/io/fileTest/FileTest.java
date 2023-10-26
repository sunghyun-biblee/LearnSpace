package com.io.fileTest;

import java.io.File;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) {
//		File클래스
		File file = new File("person.txt");
		System.out.println("파일명: "+file.getName());
		System.out.println("저장경로: "+file.getAbsolutePath());
		System.out.println("파일용량: "+file.length());
		
		try {
			// 파일이 없는 경우 파일 생성(true 리턴), 기존에 파일이 있는 경우 false 리턴
			boolean b=file.createNewFile();
			System.out.println(b);
			boolean b2=file.delete();
			System.out.println(b2);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
