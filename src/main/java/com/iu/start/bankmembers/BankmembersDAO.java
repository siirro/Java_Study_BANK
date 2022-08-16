package com.iu.start.bankmembers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.stereotype.Repository;

import com.iu.start.util.DBConnector;

@Repository
public class BankmembersDAO implements MembersDAO{
	
	public BankmembersDTO getLogin(BankmembersDTO bankmembersDTO) throws Exception{
		Connection con = DBConnector.getConnection();
		String sql="select username, name from bankmembers where username=? and password=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, bankmembersDTO.getUsername());
		st.setString(2, bankmembersDTO.getPassword());
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			bankmembersDTO = new BankmembersDTO();
			bankmembersDTO.setUsername(rs.getString("username"));
			bankmembersDTO.setName(rs.getString("name"));
			//System.out.println("로그인성공");
		} else {
			bankmembersDTO = null;
			//또는 return null;
			//System.out.println("로그인실패");
		}
		
		DBConnector.getClose(rs, st, con);
		return bankmembersDTO;
		
		
	}

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
