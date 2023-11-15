package com.test01.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyNickNamePrn {
	// Autowired 를 통하여 빈 객체를 생성시 동일한 타입 객체 빈을 생성 될 수 있게함
	// required 기본값은 true이다 > 빈 객체가 없을시 생성하길 원하지 않으면 (required = false) 붙여서 작성
	
	@Autowired
	private NickName nickName;

	public NickName getNickName() {
		return nickName;
	}

	public void setNickName(NickName nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "NickName: " + nickName;
	}
	
}
