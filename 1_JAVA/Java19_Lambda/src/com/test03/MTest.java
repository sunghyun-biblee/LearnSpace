package com.test03;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MTest {

	public static void main(String[] args) {
//		createStream();
//		createCollecion();
		pipeline();
	}

	public static void createStream() {
//		생성
//		builder() : 스트림에 직접적으로 원하는 값을 넣을 수 있다.
//		build() : 스트림 생성완료 (생성한 스트림을 리턴) 
		Stream<String> stream01 = Stream.<String>builder().add("biblee").add("ibleeb").add("bleebi").build();
		// build() -> 변수들을 모아 스트림을 만듬
		stream01.forEach(System.out::println); // stream01 손수 만든 스트림

//		empty() : 말그대로 비어 있는 스트림을 생성
		Stream<String> stream02 = Stream.empty();
		System.out.println(stream02.toArray().length);

//		generate(람다식) : Supplier<T>에 해당하는 람다식을 넣을 수 있다.
//		Supplier는 매개변수 X, 반환값(리턴)O 있는 함수형 인터페이스
		Stream<Integer> stream03 = Stream.generate(() -> 100).limit(3); // 리턴값은 Stream 타입과 같은 타입이어야 한다.
//		limit() : 얼마만큼 수행할지 제한을 걸어두는것
		stream03.forEach(System.out::println);

//		iterate : 초기값과 해당 값을 다루는 람다식을 이용해서 스트림에 들어갈 요소 생성
		Stream<Integer> stream04 = Stream.iterate(1, (i) -> ++i).limit(5); // 첫번째는 seed(초기값) , 두번째는 unaryOperator(매개변수
																			// o(1개) , 리턴값 o)
		stream04.forEach(System.out::println);

//		기본적은 스트림 생성은 직렬 스트림
//		직렬 스트림
//		병렬 스트림 / 행을 유지

		IntStream range01 = IntStream.range(1, 5);
		range01.forEachOrdered((i) -> System.out.print(i + " "));
		System.out.println();

	}

	public static void createCollecion() {

		String arr[] = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
		Stream<String> stream01 = Arrays.stream(arr);
		stream01.forEach(System.out::println);

//		원하는 방식으로 생성 가능하다.
//		List<String> list2=Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
		List<String> list = Arrays.asList(arr);
		Stream<String> stream02 = list.stream();
//		리스트에 배열을 넣어 생성 후에 스트림안에 리스트를 저장
		stream02.forEach(System.out::print);

	}

	public static void pipeline() {
//		filter : 스트림에서 뽑아져 나오는 데이터 중에서 특정 데이터만 골라내는 역할
//		filter는 boolean값 리턴하는 람다식을 넣는다.
//		collect() : Stream을 다시 Collection으로 반환해주는 기능
//		collect의 매개변수로 Collectors클래스가 제공하는 메소드 이용
		List<String> web28 = Arrays.asList("한삼식", "한동숙", "노돌리", "이초홍", "명훈", "주다영", "포셔", "쥐");
		List<String> one = web28.stream().filter(name -> name.contains("한")).sorted().collect(Collectors.toList()); //collect -> collection으로 바꿔주는 함수
		System.out.println(one);
		
		//이름이 2글자인 사람만 확인
		List<String> son2=web28.stream().filter(name->name.length()==2).sorted().collect(Collectors.toList());
		System.out.println(son2);
		
		web28.stream().filter(name->name.contains("한")).sorted().map(w->w.replace(w.substring(1,w.length()),"*".repeat(w.length()-1))).collect(Collectors.toList()).forEach(System.out::println);
		// (w.substring(1,w.length()) -> 문자열 1번에서 3번까지 자른후 그자리에  repeat를 이용하여 제한한 반복수만큼 "*"을 넣어서 값을변경한다 (replace) 이후 스트림에 맵핑하고 반복문 forEach를 통해 출력
		
		
		List<Integer> lotto=Stream.generate(()->(int)(Math.random()*45)+1).distinct().limit(7).sorted().collect(Collectors.toList());
//		distinct() => 중복제거 (먼저 들어와있는 값은 들어갈 수 없다)
		System.out.println(lotto);
		lotto.stream().forEachOrdered((i)->System.out.print(i+" "));
		System.out.println(lotto);
	}

}
