package com.tj.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.tj.ex.dto.ProductDto;

public class ProductDao {
	public static final int FAIL = 0;
	public static final int SUCCESS = 1;
	private static ProductDao instance = new ProductDao();
	public static ProductDao getInstance() {
		return instance;
	}
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	public int getProductTotCnt(String pbrand) {
		int totCnt = 0;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT COUNT(*) FROM PRODUCT WHERE PBRAND LIKE '%'||?||'%'";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pbrand);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				totCnt =rs.getInt(1);
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs   != null) rs.close();
				if(pstmt!= null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return totCnt;
	}
	public ArrayList<ProductDto> getAllProductList(int startRow, int endRow){
		ArrayList<ProductDto> dtos = new ArrayList<ProductDto>();
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM PRODUCT ORDER BY PCODE DESC) A ) WHERE RN BETWEEN ? AND ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String pcode = rs.getString("pcode");
				String pbrand = rs.getString("pbrand");
				String pname = rs.getString("pname");
				String pimg1 = rs.getString("pimg1");
				String pimg2 = rs.getString("pimg2");
				String pimg3 = rs.getString("pimg3");
				String pimg4 = rs.getString("pimg4");
				String pinfo = rs.getString("pinfo");
				dtos.add(new ProductDto(pcode, pbrand, pname, pimg1, pimg2, pimg3, pimg4, pinfo));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs   != null) rs.close();
				if(pstmt!= null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	}
	public ArrayList<ProductDto> getBrandList(String schPbrand, int startRow, int endRow){
		ArrayList<ProductDto> dtos = new ArrayList<ProductDto>();
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT rn, pcode, pbrand, pname, pimg1, pimg2, pimg3, pimg4, pinfo FROM (SELECT ROWNUM RN, A.* FROM (SELECT pcode, pbrand, pname, pimg1, pimg2, pimg3, pimg4, pinfo FROM PRODUCT WHERE PBRAND like '%'||?|| '%' ORDER BY PCODE) A ) WHERE RN BETWEEN ? AND ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, schPbrand);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String pcode = rs.getString("pcode");
				String pname = rs.getString("pname");
				String pimg1 = rs.getString("pimg1");
				String pimg2 = rs.getString("pimg2");
				String pimg3 = rs.getString("pimg3");
				String pimg4 = rs.getString("pimg4");
				String pinfo = rs.getString("pinfo");
				String pbrand = rs.getString("pbrand");
				dtos.add(new ProductDto(pcode, pbrand, pname, pimg1, pimg2, pimg3, pimg4, pinfo));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs   != null) rs.close();
				if(pstmt!= null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	}
	public ProductDto getDetileProduct(String pcode) {
		ProductDto dto = null;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM PRODUCT WHERE PCODE=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pcode);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String pbrand = rs.getString("pbrand");
				String pname = rs.getString("pname");
				String pimg1 = rs.getString("pimg1");
				String pimg2 = rs.getString("pimg2");
				String pimg3 = rs.getString("pimg3");
				String pimg4 = rs.getString("pimg4");
				String pinfo = rs.getString("pinfo");
				dto = new ProductDto(pcode, pbrand, pname, pimg1, pimg2, pimg3, pimg4, pinfo);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs   != null) rs.close();
				if(pstmt!= null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return dto;
	}
	public int insertProduct(ProductDto dto) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO PRODUCT (PCODE, PBRAND, PNAME, PIMG1, PIMG2, PIMG3, PIMG4, PINFO) VALUES " + 
				" 	(?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPcode());
			pstmt.setString(2, dto.getPbrand());
			pstmt.setString(3, dto.getPname());
			pstmt.setString(4, dto.getPimg1());
			pstmt.setString(5, dto.getPimg2());
			pstmt.setString(6, dto.getPimg3());
			pstmt.setString(7, dto.getPimg4());
			pstmt.setString(8, dto.getPinfo());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!= null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	public int updateProduct(ProductDto dto) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE PRODUCT SET PBRAND=?,PNAME=?, PIMG1=?, PIMG2=?, PIMG3=?, PIMG4=?, PINFO=? WHERE PCODE=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPbrand());
			pstmt.setString(2, dto.getPname());
			pstmt.setString(3, dto.getPimg1());
			pstmt.setString(4, dto.getPimg2());
			pstmt.setString(5, dto.getPimg3());
			pstmt.setString(6, dto.getPimg4());
			pstmt.setString(7, dto.getPinfo());
			pstmt.setString(8, dto.getPcode());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!= null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	public int deleteProduct(String pcode) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM PRODUCT WHERE PCODE=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pcode);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!= null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
}
