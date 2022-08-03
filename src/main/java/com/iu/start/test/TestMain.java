package com.iu.start.test;

import java.util.ArrayList;
import java.util.Scanner;

import com.iu.start.bankmembers.BankmembersDAO;
import com.iu.start.bankmembers.BankmembersDTO;

public class TestMain {

	public static void main(String[] args) {
		BankmembersDAO bankmembersDAO = new BankmembersDAO();
		BankmembersDTO bankmembersDTO = new BankmembersDTO();
		bankmembersDTO.setUsername("USERNAME1");
		bankmembersDTO.setPassword("PW1");
		bankmembersDTO.setName("NAME1");
		bankmembersDTO.setEmail("EMAIL1");
		bankmembersDTO.setPhone("PHONE1");
		ArrayList<BankmembersDTO> ar = new ArrayList<BankmembersDTO>();
		boolean check = true;
		
		while(check) {
		try {
			//int result = bankmembersDAO.setJoin(bankmembersDTO);
			//System.out.println(result);
			
			Scanner sc = new Scanner(System.in);
			System.out.println("찾을 아이디를 입력하세요");
			
			
			ar = bankmembersDAO.getSearchByID(sc.next());
			
			if(ar.size()==0) {
				System.out.println("없는 ID입니다");
				continue;
			}
			
			System.out.println(ar.get(0).getUsername()+"\t"+ar.get(0).getPassword()+"\t"+ar.get(0).getName()+"\t"+ar.get(0).getEmail()+"\t"+ar.get(0).getPhone());
			check = !check;
			

			
		} //catch (IndexOutOfBoundsException ioobe) {
			//System.out.println("없는 ID 입니다");
		//} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		}
	}

}
