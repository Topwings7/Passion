package com.tj.ex.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.tj.ex.dto.CustomerDto;
import com.tj.ex.dto.EventDto;

public class EventDao {
	public static final int FAIL = 0;
	public static final int SUCCESS = 1;
	private static EventDao instance = new EventDao();
	public static EventDao getInstance() {
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
	public int insertnumber(EventDto dto) {
		int result = FAIL;
		Connection conn         = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO EVENT VALUES(E_SEQ.NEXTVAL, ?,?,?,?,?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getNo1());
			pstmt.setInt(2, dto.getNo2());
			pstmt.setInt(3, dto.getNo3());
			pstmt.setInt(4, dto.getNo4());
			pstmt.setInt(5, dto.getNo5());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	public int getEventTotCnt() {
		int totCnt = 0;
		Connection conn         = null;
		PreparedStatement pstmt = null;
		ResultSet            rs = null;
		String sql = "SELECT COUNT(*) FROM EVENT";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				totCnt = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return totCnt;
	}
	public ArrayList<EventDto> getEventList(int startRow, int endRow){
		ArrayList<EventDto> dtos = new ArrayList<EventDto>();
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM (SELECT ROWNUM RN, A.* FROM(SELECT * FROM EVENT ORDER BY NUM DESC) A ) WHERE RN BETWEEN ? AND ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int num = rs.getInt("num");
				int no1 = rs.getInt("no1");
				int no2 = rs.getInt("no2");
				int no3 = rs.getInt("no3");
				int no4 = rs.getInt("no4");
				int no5 = rs.getInt("no5");
				dtos.add(new EventDto(num, no1, no2, no3, no4, no5));
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
	public EventDto getChanceNumber(int num) {
		EventDto dto = null;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM EVENT WHERE NUM=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int no1 = rs.getInt("no1");
				int no2 = rs.getInt("no2");
				int no3 = rs.getInt("no3");
				int no4 = rs.getInt("no4");
				int no5 = rs.getInt("no5");
				dto = new EventDto(num, no1, no2, no3, no4, no5);
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
	public int ChanceResult(String cid) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql  = "UPDATE CUSTOMER SET CRESULT=CRESULT+1 WHERE CID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cid);
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
	public ArrayList<CustomerDto> ChanceResultView() {
		ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM CUSTOMER WHERE CRESULT=1";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String cid = rs.getString("cid");
				String cpass = rs.getString("cpass");
				String cname = rs.getString("cname");
				String ctel = rs.getString("ctel");
				String caddress = rs.getString("caddress");
				Date   crdate   = rs.getDate("crdate");
				int    cresult = rs.getInt("cresult");
				dtos.add(new CustomerDto(cid, cpass, cname, ctel, caddress, crdate, cresult));
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
}
