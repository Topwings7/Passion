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

import com.tj.ex.dto.BoardDto;

public class BoardDao {
	public static final int FAIL = 0;
	public static final int SUCCESS = 1;
	private static BoardDao instance = new BoardDao();
	public static BoardDao getInstance() {
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
	public int getBoardTotCnt() {
		int totCnt = 0;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT COUNT(*) FROM BOARD";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
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
	public ArrayList<BoardDto> getBoardList(int startRow, int endRow){
		ArrayList<BoardDto> dtos = new ArrayList<BoardDto>();
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM (SELECT ROWNUM RN, A.* FROM(SELECT B.* FROM BOARD B, CUSTOMER C WHERE B.CID=C.CID ORDER BY BGROUP DESC, BSTEP) A ) WHERE RN BETWEEN ? AND ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int bid			 = rs.getInt("bid");
				String cid		 = rs.getString("cid");
				String btitle	 = rs.getString("btitle");
				String bcontent  = rs.getString("bcontent");
				int bhit		 = rs.getInt("bhit");
				int bgroup		 = rs.getInt("bgroup");
				int bstep		 = rs.getInt("bstep");
				int bindent		 = rs.getInt("bindent");
				String bip		 = rs.getString("bip");
				Date brdate	 	 = rs.getDate("brdate");
				dtos.add(new BoardDto(bid, cid, btitle, bcontent, bhit, bgroup, bstep, bindent, bip, brdate));
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
	public int writeBoard(BoardDto dto) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO BOARD (BID, CID, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP) VALUES " + 
				"	(BOARD_SEQ.NEXTVAL, ?, ?, ?, BOARD_SEQ.CURRVAL, 0, 0, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCid());
			pstmt.setString(2, dto.getBtitle());
			pstmt.setString(3, dto.getBcontent());
			pstmt.setString(4, dto.getBip());
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
	public void hitUpBoard(int bid) {
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE BOARD SET BHIT = BHIT+1 WHERE BID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			pstmt.executeUpdate();
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
	}
	public BoardDto contentViewBoard(int bid) {
		hitUpBoard(bid);
		BoardDto dto = null;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT B.* FROM BOARD B, CUSTOMER C WHERE B.CID=C.CID AND BID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String cid		 = rs.getString("cid");
				String btitle	 = rs.getString("btitle");
				String bcontent  = rs.getString("bcontent");
				int bhit		 = rs.getInt("bhit");
				int bgroup		 = rs.getInt("bgroup");
				int bstep		 = rs.getInt("bstep");
				int bindent		 = rs.getInt("bindent");
				String bip		 = rs.getString("bip");
				Date brdate	 	 = rs.getDate("brdate");
				dto = new BoardDto(bid, cid, btitle, bcontent, bhit, bgroup, bstep, bindent, bip, brdate);
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
	public BoardDto modifyView_replyView(int bid) {
		BoardDto dto = null;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT B.* FROM BOARD B, CUSTOMER C WHERE B.CID=C.CID AND BID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String cid		 = rs.getString("cid");
				String btitle	 = rs.getString("btitle");
				String bcontent  = rs.getString("bcontent");
				int bhit		 = rs.getInt("bhit");
				int bgroup		 = rs.getInt("bgroup");
				int bstep		 = rs.getInt("bstep");
				int bindent		 = rs.getInt("bindent");
				String bip		 = rs.getString("bip");
				Date brdate	 	 = rs.getDate("brdate");
				dto = new BoardDto(bid, cid, btitle, bcontent, bhit, bgroup, bstep, bindent, bip, brdate);
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
	public int modifyBoard(BoardDto dto) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE BOARD SET BTITLE=?, BCONTENT=?, BRDATE=SYSDATE WHERE BID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getBtitle());
			pstmt.setString(2, dto.getBcontent());
			pstmt.setInt(3, dto.getBid());
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
	public int deleteBoard(int bid) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM BOARD WHERE BID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
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
	public void replyBeforeStepA(int bgroup, int bstep) {
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql ="UPDATE BOARD SET BSTEP = BSTEP+1 WHERE BGROUP=? AND BSTEP>?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bgroup);
			pstmt.setInt(2, bstep);
			pstmt.executeUpdate();
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
	}
	public int replyWriteBoard(BoardDto dto) {
		int result = FAIL;
		replyBeforeStepA(dto.getBgroup(),dto.getBstep());
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql= "INSERT INTO BOARD (BID, CID, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP) VALUES " + 
				"			(BOARD_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCid());
			pstmt.setString(2, dto.getBtitle());
			pstmt.setString(3, dto.getBcontent());
			pstmt.setInt(4, dto.getBgroup());
			pstmt.setInt(5, dto.getBstep()+1);
			pstmt.setInt(6, dto.getBindent()+1);
			pstmt.setString(7, dto.getBip());
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

