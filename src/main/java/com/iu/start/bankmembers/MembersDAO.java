package com.iu.start.bankmembers;

import java.util.List;

public interface MembersDAO {
	
	//bankMembers 회원가입
	public int setJoin(BankmembersDTO bankMembersDTO) throws Exception;
	
	
	//검색어를 입력해서 아이디를 찾을거임 abc 순으로
	public List<BankmembersDTO> getSearchByID(String search) throws Exception;

}


