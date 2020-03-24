package com.tj.ex.dto;

public class ProductDto {
	private String pcode;
	private String pbrand;
	private String pname;
	private String pimg1;
	private String pimg2;
	private String pimg3;
	private String pimg4;
	private String pinfo;
	public ProductDto() {}
	public ProductDto(String pcode, String pbrand, String pname, String pimg1, String pimg2, String pimg3, String pimg4,
			String pinfo) {
		this.pcode = pcode;
		this.pbrand = pbrand;
		this.pname = pname;
		this.pimg1 = pimg1;
		this.pimg2 = pimg2;
		this.pimg3 = pimg3;
		this.pimg4 = pimg4;
		this.pinfo = pinfo;
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public String getPbrand() {
		return pbrand;
	}
	public void setPbrand(String pbrand) {
		this.pbrand = pbrand;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPimg1() {
		return pimg1;
	}
	public void setPimg1(String pimg1) {
		this.pimg1 = pimg1;
	}
	public String getPimg2() {
		return pimg2;
	}
	public void setPimg2(String pimg2) {
		this.pimg2 = pimg2;
	}
	public String getPimg3() {
		return pimg3;
	}
	public void setPimg3(String pimg3) {
		this.pimg3 = pimg3;
	}
	public String getPimg4() {
		return pimg4;
	}
	public void setPimg4(String pimg4) {
		this.pimg4 = pimg4;
	}
	public String getPinfo() {
		return pinfo;
	}
	public void setPinfo(String pinfo) {
		this.pinfo = pinfo;
	}
	@Override
	public String toString() {
		return "ProductDto [pcode=" + pcode + ", pbrand=" + pbrand + ", pname=" + pname + ", pimg1=" + pimg1;
				//+ ", pimg2=" + pimg2 + ", pimg3=" + pimg3 + ", pimg4=" + pimg4 + ", pinfo=" + pinfo + "]";
	}
}
