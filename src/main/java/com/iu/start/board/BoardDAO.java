package com.iu.start.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.start.util.DBConnector;

public class BoardDAO {
	
	public ArrayList<BoardDTO> getlist()throws Exception {
		ArrayList<BoardDTO> ar = new ArrayList<BoardDTO>();
		BoardDTO boardDTO = null;
		Connection con = DBConnector.getConnection();
		String sql = "SELECT * FROM BOARD";
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			boardDTO = new BoardDTO();
			boardDTO.setBoardNum(rs.getInt("boardNum"));
			boardDTO.setBoardTitle(rs.getString("boardTitle"));
			boardDTO.setBoardContent(rs.getString("boardContent"));
			boardDTO.setBoardWriter(rs.getString("boardwriter"));
			boardDTO.setBoardDate(rs.getDate("boarddate"));
			boardDTO.setBoardHit(rs.getInt("boardhit"));
			ar.add(boardDTO);
			
		}
		
		DBConnector.getClose(rs, st, con);
		return ar;
		
	}
	
	public BoardDTO getDetail(BoardDTO boardDTO)throws Exception {
		Connection con = DBConnector.getConnection();
		String sql = "SELECT * FROM BOARD WHERE BOARDNUM = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, boardDTO.getBoardNum());
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			boardDTO.setBoardNum(rs.getInt("boardNum"));
			boardDTO.setBoardTitle(rs.getString("boardTitle"));
			boardDTO.setBoardContent(rs.getString("boardContent"));
			boardDTO.setBoardWriter(rs.getString("boardwriter"));
			boardDTO.setBoardDate(rs.getDate("boarddate"));
			boardDTO.setBoardHit(rs.getInt("boardhit"));
		}
		
		DBConnector.getClose(rs, st, con);
		return boardDTO;
		
	}
	
	public int add(BoardDTO boardDTO)throws Exception {
		Connection con = DBConnector.getConnection();
		String sql = "INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL, ?, ?, ?, SYSDATE, 0)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, boardDTO.getBoardTitle());
		st.setString(2, boardDTO.getBoardContent());
		st.setString(3, boardDTO.getBoardWriter());
		
		int result = st.executeUpdate();
		
		DBConnector.getClose(st, con);
		return result;
	
	
	}
	
	public int delete(BoardDTO boardDTO)throws Exception {
		Connection con = DBConnector.getConnection();
		String sql = "DELETE FROM BOARD WHERE BOARDNUM = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, boardDTO.getBoardNum());
		
		int result = st.executeUpdate();
		
		DBConnector.getClose(st, con);
		return result;
	}
	
	public int update(BoardDTO boardDTO)throws Exception{
		Connection con = DBConnector.getConnection();
		String sql = "UPDATE BOARD SET BOARDTITLE=?, BOARDCONTENT=? WHERE BOARDNUM=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, boardDTO.getBoardTitle());
		st.setString(2, boardDTO.getBoardContent());
		st.setInt(3, boardDTO.getBoardNum());
		
		int result = st.executeUpdate();
		
		DBConnector.getClose(st, con);
		return result;
	}

}
