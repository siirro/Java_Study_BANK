package com.iu.start.bankmembers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankmembersService {
	
	@Autowired
	private BankmembersDAO bankmembersDAO;
	
	
	//로그인
	public BankmembersDTO getLogin(BankmembersDTO bankmembersDTO)throws Exception{
		return bankmembersDAO.getLogin(bankmembersDTO);
	}
	
	//bankMembers 회원가입
	public int setJoin(BankmembersDTO bankMembersDTO) throws Exception {
		return bankmembersDAO.setJoin(bankMembersDTO);
	}
		
	//검색어를 입력해서 아이디를 찾을거임 abc 순으로
	public ArrayList<BankmembersDTO> getSearchByID(String search) throws Exception {
		return bankmembersDAO.getSearchByID(search);
		
	}
}
