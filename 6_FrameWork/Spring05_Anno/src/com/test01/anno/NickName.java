package com.test01.anno;

import org.springframework.stereotype.Component;

@Component
public class NickName {

	@Override
	public String toString() {
		return "biblee";
	}

}

// component를 작성하면 자동으로 클래스가 빈으로 등록됨