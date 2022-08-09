package com.iu.start.bankmembers;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iu.start.bankBook.BankBookDTO;


@Controller 
@RequestMapping(value="/member/*")
//이 클래스는 Controller역할, Container에게 이 클래스의 객체를 생성 위임
public class MemberController {
	// annotation
	// @이게 어노테이션이다. : 설명 + 실행
	
	// /member/login 절대경로로 써야함
	@RequestMapping(value ="login")
	public String login() {
		System.out.println("login 실행");
		return "member/login";
		
	}
	// join /member/join - Get
	@RequestMapping(value ="join", method = RequestMethod.GET)
	public String join() {
		System.out.println("Join Get 실행");
		return "member/join";
	}
	
	// join - Post
	@RequestMapping(value ="join", method = RequestMethod.POST)
	//public String join(HttpServletRequest request) throws Exception {
	public String join(BankmembersDTO bankmembersDTO) throws Exception {
		System.out.println("Join Post 실행");
		//String ID = request.getParameter("id");
		
		
		BankmembersDAO bDAO = new BankmembersDAO();
		
		
		
//		BankmembersDTO bDTO = new BankmembersDTO();
//		
//		bDTO.setUsername(username);
//		bDTO.setPassword(password);
//		bDTO.setName(name);
//		bDTO.setEmail(email);
//		bDTO.setPhone(phone);
//		
		
		
		int check = bDAO.setJoin(bankmembersDTO);
		System.out.println(check==1);
		
		
		return "member/join";
	}
		
	
}
