package com.iu.start.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.iu.start.bankBook.BankBookDAO;
import com.iu.start.bankBook.BankBookDTO;
import com.iu.start.bankmembers.BankmembersDAO;
import com.iu.start.bankmembers.BankmembersDTO;

public class TestMain {

	public static void main(String[] args) {
		/*
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
		*/
		
		BankBookDTO bankbookDTO = null;
		BankBookDAO bankbookDAO = new BankBookDAO();
		// 220803 오후 1번메서드
		
		/*
		bankbookDTO = new BankBookDTO();
		bankbookDTO.setBookname("내통장1");
		bankbookDTO.setBookrate(1.5);
		
		
		try {
			int result = bankbookDAO.setBankBook(bankbookDTO);
			System.out.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		/*
		// 2번메서드
		ArrayList<BankBookDTO> ar = new ArrayList<BankBookDTO>();
		try {
			ar = bankbookDAO.getList();
			
			for(int i=0;i<ar.size();i++) {
				System.out.println(ar.get(i).getBooknum()
						+"\t"+ar.get(i).getBookname()
						+"\t"+ar.get(i).getBookrate()
						+"\t"+ar.get(i).getBooksale());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		*/
		
		/*
		// 3번
		bankbookDTO = new BankBookDTO();
		bankbookDAO = new BankBookDAO();
		
		try {
			
			bankbookDAO.setChangeSale(bankbookDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		//3번끝
		
		
		//4번시작
		boolean check = true;
		while(check) {
		try {
			bankbookDTO = bankbookDAO.getDetail(bankbookDTO);
			
			
			
			if(bankbookDTO.getBooknum()==null) {
				System.out.println("계좌가 없습니다");
				continue;
			}
			
			System.out.println("북넘"+"\t"+"북네임"+"\t"+"금리"+"\t"+"판매여부");
			System.out.println(bankbookDTO.getBooknum()
					+"\t"+bankbookDTO.getBookname()
					+"\t"+bankbookDTO.getBookrate()
					+"\t"+bankbookDTO.getBooksale()
			);
			check = !check;
			
			
		}
		 catch (NullPointerException npe) {
			System.out.println("입력한 북넘은 없는 계좌입니다");
		} 
		catch ( InputMismatchException im) {
			System.out.println("숫자를 입력하셈");
		}
		
		catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		//4번끝
		
	}

}