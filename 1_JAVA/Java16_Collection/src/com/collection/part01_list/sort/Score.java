package com.collection.part01_list.sort;

import java.util.Objects;

public class Score implements Comparable<Score>{
//	필드
	private String name;
	private int score;

//	생성자
	public Score() {

	}

	public Score(String name, int score) {
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, score);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Score other = (Score) obj;
		return Objects.equals(name, other.name) && score == other.score;
	}

	@Override
	public String toString() {
		return "[name="+name+", score="+score+"]";
	}

	@Override
	public int compareTo(Score o) {
		// 기본정렬 기준으로 name 오름차순
		String otherName=o.getName();
		return this.name.compareTo(otherName);
//		return -this.name.compareTo(otherName); // 이름 내림차순
		
		//리턴 값 -> 음수면 자리를 바꾸지 않는다
		//리턴 값 -> 양수면 자리를 바꾼다
	}
}
