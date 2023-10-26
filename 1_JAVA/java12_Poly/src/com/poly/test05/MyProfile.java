package com.poly.test05;
//자바는 단일 상속밖에 되지않지만 상속과 인터페이스를 통해 여러가지를 한클래스에 상속할수있다(야매다중상속)
public class MyProfile extends Profile implements Job ,Display{
	// 필드
	private String loc;
	
	//생성자
	public MyProfile() {
	}
	public MyProfile(String name,String phone) {
		super(name,phone);
	}
	
	@Override
	public void jobLoc(String loc) {
		this.loc=loc;
	}
	
	@Override
	public void display() {
		super.printProfile();
		System.out.println("회사주소 : "+loc);
		System.out.println("회사직종 : "+jobId);
	}

}
