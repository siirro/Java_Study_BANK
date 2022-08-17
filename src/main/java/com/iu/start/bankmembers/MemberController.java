package com.iu.start.bankmembers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.start.bankBook.BankBookDTO;


@Controller 
@RequestMapping(value="/member/*")
//이 클래스는 Controller역할, Container에게 이 클래스의 객체를 생성 위임
public class MemberController {
	
	@Autowired
	BankmembersService bankmembersService;
	
	@RequestMapping(value="search", method = RequestMethod.GET)
	public void getSearchByID() {
		System.out.println("search get실행");
	}
	
	@RequestMapping(value="search", method = RequestMethod.POST)
	public String getSearchByID(String search, Model model) throws Exception {
		System.out.println("search post실행");
		System.out.println(search);
		
		List<BankmembersDTO> ar = bankmembersService.getSearchByID(search);
		
		model.addAttribute("list", ar);
		
//		mv.setViewName("member/list");
//		mv.addObject("list", ar);
		
		return "member/list";
	}
	
	
	
	
	// annotation
	// @이게 어노테이션이다. : 설명 + 실행
	
	// /member/login 절대경로로 써야함
	@RequestMapping(value ="login.iu", method = RequestMethod.GET)
	public String login() {
		System.out.println("login 실행");
		return "member/login";
	}
		
	@RequestMapping(value ="login.iu", method = RequestMethod.POST)
	public String login(HttpServletRequest request, BankmembersDTO bankmembersDTO) throws Exception {
		System.out.println("login 실행");
		bankmembersDTO = bankmembersService.getLogin(bankmembersDTO);
		System.out.println(bankmembersDTO);
		HttpSession session = request.getSession();
		session.setAttribute("member", bankmembersDTO);
		
		//model.addAttribute("member", bankmembersDAO);
		
		
		//"redirect:다시접속할URL주소(절대경로,상대경로)
		return "redirect:../";
		//return "home";
		
	}
	
	@RequestMapping(value="logout.iu", method = RequestMethod.GET)
	public String logout(HttpSession session)throws Exception{
		session.invalidate();
		
		return "redirect:../";
	}
	
	// join /member/join - Get
	@RequestMapping(value ="join.iu", method = RequestMethod.GET)
	public void join() {
		System.out.println("Join Get 실행");
		//return "member/join";
	}
	
	// join - Post
	@RequestMapping(value ="join.iu", method = RequestMethod.POST)
	//public String join(HttpServletRequest request) throws Exception {
	public String join(BankmembersDTO bankmembersDTO) throws Exception {
		System.out.println("Join Post 실행");
		//String ID = request.getParameter("id");

		int check = bankmembersService.setJoin(bankmembersDTO);

		
		return "redirect:./login.iu";
	}
		
	
}
