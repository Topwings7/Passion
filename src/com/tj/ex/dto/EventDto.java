package com.tj.ex.dto;

public class EventDto {
	private int num;
	private int no1;
	private int no2;
	private int no3;
	private int no4;
	private int no5;
	public EventDto() {
	}
	public EventDto(int num, int no1, int no2, int no3, int no4, int no5) {
		this.num = num;
		this.no1 = no1;
		this.no2 = no2;
		this.no3 = no3;
		this.no4 = no4;
		this.no5 = no5;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getNo1() {
		return no1;
	}
	public void setNo1(int no1) {
		this.no1 = no1;
	}
	public int getNo2() {
		return no2;
	}
	public void setNo2(int no2) {
		this.no2 = no2;
	}
	public int getNo3() {
		return no3;
	}
	public void setNo3(int no3) {
		this.no3 = no3;
	}
	public int getNo4() {
		return no4;
	}
	public void setNo4(int no4) {
		this.no4 = no4;
	}
	public int getNo5() {
		return no5;
	}
	public void setNo5(int no5) {
		this.no5 = no5;
	}
	@Override
	public String toString() {
		return "EventDto [num=" + num + ", no1=" + no1 + ", no2=" + no2 + ", no3=" + no3 + ", no4=" + no4 + ", no5="
				+ no5 + "]";
	}
	
}
