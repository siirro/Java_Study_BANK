package com.iu.start.bankBook;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/bankbook/*")
public class BankBookController {
	
	// /bankbook/list  Get   list()
	
	@RequestMapping(value="list", method = RequestMethod.GET)
	public String list() {
		System.out.println("list 실행");
		return "bankbook/list";
	}
	
	
	
	// /bankbook/detail Get detail()
	
	@RequestMapping(value="detail", method = RequestMethod.GET)
	public String detail(Long bookNum) {
		System.out.println("detail 실행");
		System.out.println(bookNum);
		return "bankbook/detail";
	}
	
	@RequestMapping(value="add", method = RequestMethod.GET)
	public String add() {
		System.out.println("add 실행 get");
		return "bankbook/add";
	}
	
	@RequestMapping(value="add", method = RequestMethod.POST)
	public String add(BankBookDTO bDTO) throws Exception {
		System.out.println("add 실행 post");
		BankBookDAO bankbookDAO = new BankBookDAO();
		int check = bankbookDAO.setBankBook(bDTO);
		return "bankbook/add";
	}
	
	
}
