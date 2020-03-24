package com.tj.ex.dto;

import java.sql.Date;

public class BoardDto {
	private int bid;
	private String cid;
	private String btitle;
	private String bcontent;
	private int bhit;
	private int bgroup;
	private int bstep;
	private int bindent;
	private String bip;
	private Date brdate;
	public BoardDto() {
	}
	public BoardDto(int bid, String cid, String btitle, String bcontent, int bhit, int bgroup, int bstep, int bindent, String bip, Date brdate) {
		this.bid = bid;
		this.cid = cid;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bhit = bhit;
		this.bgroup = bgroup;
		this.bstep = bstep;
		this.bindent = bindent;
		this.bip = bip;
		this.brdate = brdate;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public int getBhit() {
		return bhit;
	}
	public void setBhit(int bhit) {
		this.bhit = bhit;
	}
	public int getBgroup() {
		return bgroup;
	}
	public void setBgroup(int bgroup) {
		this.bgroup = bgroup;
	}
	public int getBstep() {
		return bstep;
	}
	public void setBstep(int bstep) {
		this.bstep = bstep;
	}
	public int getBindent() {
		return bindent;
	}
	public void setBindent(int bindent) {
		this.bindent = bindent;
	}
	public String getBip() {
		return bip;
	}
	public void setBip(String bip) {
		this.bip = bip;
	}
	public Date getBrdate() {
		return brdate;
	}
	public void setBrdate(Date brdate) {
		this.brdate = brdate;
	}
	@Override
	public String toString() {
		return "BoardDto [bid=" + bid + ", cid=" + cid + ", btitle=" + btitle + ", bcontent=" + bcontent + ", bhit="
				+ bhit + ", bgroup=" + bgroup + ", bstep=" + bstep + ", bindent=" + bindent + ", bip=" + bip
				+ ", brdate=" + brdate + "]";
	}
}
