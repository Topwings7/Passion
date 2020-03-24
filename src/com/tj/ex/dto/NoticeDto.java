package com.tj.ex.dto;

import java.sql.Date;

public class NoticeDto {
	private int nnum;
	private String mid;
	private String nname;
	private String ncontent;
	private Date nrdate;
	public NoticeDto() {
	}
	public NoticeDto(int nnum, String mid, String nname, String ncontent, Date nrdate) {
		this.nnum = nnum;
		this.mid = mid;
		this.nname = nname;
		this.ncontent = ncontent;
		this.nrdate = nrdate;
	}
	public int getNnum() {
		return nnum;
	}
	public void setNnum(int nnum) {
		this.nnum = nnum;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getNname() {
		return nname;
	}
	public void setNname(String nname) {
		this.nname = nname;
	}
	public String getNcontent() {
		return ncontent;
	}
	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}
	public Date getNrdate() {
		return nrdate;
	}
	public void setNrdate(Date nrdate) {
		this.nrdate = nrdate;
	}
	@Override
	public String toString() {
		return "NoticeDto [nnum=" + nnum + ", mid=" + mid + ", nname=" + nname + ", ncontent=" + ncontent + ", nrdate="
				+ nrdate + "]";
	}
}
