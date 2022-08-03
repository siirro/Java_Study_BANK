package com.iu.start.bankmembers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import com.iu.start.util.DBConnector;

public class BankmembersDAO implements MembersDAO{

	public int setJoin(BankmembersDTO bankMembersDTO) throws Exception {
		
		Connection con = DBConnector.getConnection();
		String sql = "INSERT INTO BANKMEMBERS VALUES(?,?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);

		st.setString(1, bankMembersDTO.getUsername());
		st.setString(2, bankMembersDTO.getPassword());
		st.setString(3, bankMembersDTO.getName());
		st.setString(4, bankMembersDTO.getEmail());
		st.setString(5, bankMembersDTO.getPhone());
		
		int result = st.executeUpdate();
		
		DBConnector.getClose(st, con);
		
		return result;
	}

	
	
	@Override
	public ArrayList<BankmembersDTO> getSearchByID(String search) throws Exception {
		
		ArrayList<BankmembersDTO> ar = new ArrayList<BankmembersDTO>();
		BankmembersDTO bankmembersDTO = null;
		
		
		//검색어를 입력해서 아이디를 찾을거임 abc 순으로
		Connection con = DBConnector.getConnection();
		String sql = "SELECT * FROM BANKMEMBERS WHERE USERNAME LIKE ? ORDER BY USERNAME ASC";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, search);
		st.setString(1, "%"+search+"%");
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			bankmembersDTO = new BankmembersDTO();
			bankmembersDTO.setUsername(rs.getString("USERNAME"));
			bankmembersDTO.setPassword(rs.getString("PASSWORD"));
			bankmembersDTO.setName(rs.getString("NAME"));
			bankmembersDTO.setEmail(rs.getString("EMAIL"));
			bankmembersDTO.setPhone(rs.getString("PHONE"));
			
			ar.add(bankmembersDTO);
		}
		
		DBConnector.getClose(rs, st, con);
		
		return ar;
		
		
	}
	


}
