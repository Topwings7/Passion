package com.tj.ex.dto;

public class MasterDto {
	private String mid;
	private String mpass;
	public MasterDto() {
	}
	public MasterDto(String mid, String mpass) {
		this.mid = mid;
		this.mpass = mpass;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMpass() {
		return mpass;
	}
	public void setMpass(String mpass) {
		this.mpass = mpass;
	}
	@Override
	public String toString() {
		return "MasterDto [mid=" + mid + ", mpass=" + mpass + "]";
	}
}
