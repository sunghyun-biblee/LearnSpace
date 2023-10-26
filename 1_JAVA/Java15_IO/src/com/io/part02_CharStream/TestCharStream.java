package com.io.part02_CharStream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestCharStream {
	public void fileSave() {

		FileWriter fw = null;
		try {
//			1. 스트림 생성 (통로 연결)
			fw = new FileWriter("sample2.txt");

//			2. 외부자원으로 출력
			fw.write("비가오는 화요일 ");
			fw.write('a');
			fw.write(' ');
			char carr[] = { 'b', 'i', 'b', 'l', 'e', 'e' };
			fw.write(carr);

			System.out.println(fw);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
//				3. close()
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public void fileOpen() {
		FileReader fr = null;

		try {
//			1. 스트림생성
			fr = new FileReader("sample2.txt");
//			2. 외부 파일로부터 데이터 입력
			int value;
			while ((value = fr.read()) != -1) {
				System.out.print((char) value);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
