package com.io.part03_addStream.chap02_byteTochar.run;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TestStreamChange {
	public static void main(String[] args) {
		TestStreamChange tsc = new TestStreamChange();
//		tsc.input();
		tsc.output();
	}

	public void input() {
//		InputStreamReader	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			System.out.println("문자열 입력: ");
			String value = br.readLine();
			System.out.println("value : " + value);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void output() {
		// new 보조스트림 (new 보조스티림 (new 기반스트림("외부자원")));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			bw.write("내일부터 추석 연휴!");
			
			//버퍼에 잔류해 있는 내용을 밀어내기 위해 사용
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
