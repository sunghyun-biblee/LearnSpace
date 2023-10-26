package com.test.chap03_field.test02;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		InitBlock ib=new InitBlock();
		ib.information();
		
		
		InitBlock ib2=new InitBlock("z플립",2000000,"samsung");
		ib2.information();
		ib.information();
		
	}

}
