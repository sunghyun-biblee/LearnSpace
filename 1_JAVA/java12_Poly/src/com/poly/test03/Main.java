package com.poly.test03;

public class Main {

	public static void main(String[] args) {
		Animal ani=new Cat();
		
		ani.bark();
		ani.eat("참치");

		ani=new Dog();
		ani.bark();
		ani.eat("사료");
		((Dog)ani).bite(); // => Animal한테 상속받아 타입이 부모타입을 따라가게됨 -> Dog타입이라는걸 형변환시켜 인식후 실행가능 
		
		ani=new Eagle();
		((Eagle)ani).fly(); 
		ani.bark();
		ani.eat("토끼");
		
		
		
		Bird b=new Eagle();
		b.fly();
		((Eagle)b).bark();  // 위 또한 인터페이스를 기준으로 객체를 생성하였기때문에 bark는 Animal에서 상속받아온것이기에 Eagle 타입에 bark가 존재한다는걸(형변환) 인식시켜줘야함 
	}

}
