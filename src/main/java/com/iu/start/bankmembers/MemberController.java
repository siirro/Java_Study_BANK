package com.iu.start.bankmembers;

import javax.servlet.RequestDispatcher;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller 
//이 클래스는 Controller역할, Container에게 이 클래스의 객체를 생성 위임
public class MemberController {
	// annotation
	// @이게 어노테이션이다. : 설명 + 실행
	
	// /member/login 
	@RequestMapping(value ="/member/login")
	public void login() {
		System.out.println("login 실행");
		
	}
	// join /member/join
	
	@RequestMapping(value ="/member/join")
	public void join() {
		System.out.println("Join 실행");
	}
	
		
	
}
