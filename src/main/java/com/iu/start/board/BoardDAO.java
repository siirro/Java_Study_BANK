package com.iu.start.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.start.util.DBConnector;

public class BoardDAO {
	
	
	
	/*1. 글목록보기(list)
	URL       : /board/list.확장자    -- 확장자는 개발자 마음대로
	Method    : GET
	JSP       : /WEB-INF/views/board/list.jsp
	Parameter : 없음
	*/
	
	public ArrayList<BoardDTO> getlist()throws Exception {
		Connection con = DBConnector.getConnection();
		String sql = "SELECT * FROM BOARD";
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		ArrayList<BoardDTO> ar = new ArrayList();
		
		if(rs.next()) {
			BoardDTO boardDTO = new BoardDTO();
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

}
