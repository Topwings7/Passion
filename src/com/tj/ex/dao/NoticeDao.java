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

import com.tj.ex.dto.NoticeDto;

public class NoticeDao {
	public static final int FAIL = 0;
	public static final int SUCCESS = 1;
	private static NoticeDao instance = new NoticeDao();
	public static NoticeDao getInstance() {
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
	public int writeNotice(NoticeDto dto) {
		int result = FAIL;
		Connection conn         = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO NOTICE (NNUM, MID, NNAME, NCONTENT) VALUES (NOTICE_SEQ.NEXTVAL, ?, ?, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMid());
			pstmt.setString(2, dto.getNname());
			pstmt.setString(3, dto.getNcontent());
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
	public NoticeDto getNotice(int nnum) {
		NoticeDto dto = null;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM NOTICE WHERE NNUM=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nnum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String mid      = rs.getString("mid");
				String nname    = rs.getString("nname");
				String ncontent = rs.getString("ncontent");
				Date nrdate	    = rs.getDate("nrdate");
				dto = new NoticeDto(nnum, mid, nname, ncontent, nrdate);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs    != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return dto;
	}
	public int deleteNotice(int nnum) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM NOTICE WHERE NNUM=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nnum);
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
	public ArrayList<NoticeDto> allgetNotice(){
		ArrayList<NoticeDto> dtos = new ArrayList<NoticeDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="SELECT * FROM (SELECT ROWNUM RN, A.* FROM(SELECT N.* FROM NOTICE N, MASTER M WHERE N.MID=M.MID ORDER BY NNUM DESC) A) WHERE RN BETWEEN 1 AND 7";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int    nnum     = rs.getInt("nnum");
				String mid      = rs.getString("mid");
				String nname    = rs.getString("nname");
				String ncontent = rs.getString("ncontent");
				Date nrdate	    = rs.getDate("nrdate");
				dtos.add(new NoticeDto(nnum, mid, nname, ncontent, nrdate));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs    != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	}
}

