package com.tj.ex.dto;

import java.sql.Date;

public class CustomerDto {
	private String cid;
	private String cpass;
	private String cname;
	private String ctel;
	private String caddress;
	private Date   crdate;
	private int    cresult;
	public CustomerDto() {
	}
	public CustomerDto(String cid, String cpass, String cname, String ctel, String caddress, Date crdate, int cresult) {
		this.cid = cid;
		this.cpass = cpass;
		this.cname = cname;
		this.ctel = ctel;
		this.caddress = caddress;
		this.crdate = crdate;
		this.cresult = cresult;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCpass() {
		return cpass;
	}
	public void setCpass(String cpass) {
		this.cpass = cpass;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCtel() {
		return ctel;
	}
	public void setCtel(String ctel) {
		this.ctel = ctel;
	}
	public String getCaddress() {
		return caddress;
	}
	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}
	public Date getCrdate() {
		return crdate;
	}
	public void setCrdate(Date crdate) {
		this.crdate = crdate;
	}
	public int getCresult() {
		return cresult;
	}
	public void setCresult(int cresult) {
		this.cresult = cresult;
	}
	@Override
	public String toString() {
		return "CustomerDto [cid=" + cid + ", cpass=" + cpass + ", cname=" + cname + ", ctel=" + ctel + ", caddress="
				+ caddress + ", crdate=" + crdate + ", cresult=" + cresult + "]";
	}
}