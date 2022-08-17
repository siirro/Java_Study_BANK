package com.iu.start.bankmembers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankmembersService {
	
	@Autowired
	BankmembersDAO bankmembersDAO;
	
	
	public BankmembersDTO getLogin(BankmembersDTO bankmemberDTO)throws Exception{
		return bankmembersDAO.getLogin(bankmemberDTO);
	}
		
	public int setJoin(BankmembersDTO bankMembersDTO) throws Exception{
		return bankmembersDAO.setJoin(bankMembersDTO);
	}	
	
	//검색어를 입력해서 아이디를 찾을거임 abc 순으로
	public List<BankmembersDTO> getSearchByID(String search) throws Exception{
		return bankmembersDAO.getSearchByID(search);
	}

}
