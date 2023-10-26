package com.poly.test04;

public abstract class AreaImpl implements Area{
	
	private String result;
	
	
	@Override
	public void print() {
		System.out.println(Area.print+result);
	}
	@Override
	public abstract void make();
	
	public void setResult(String result) {
		this.result=result;
	}
}
