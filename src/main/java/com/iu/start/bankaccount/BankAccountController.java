package com.iu.start.bankaccount;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;import com.iu.start.bankBook.BankBookDTO;
import com.iu.start.bankmembers.BankmembersDTO;

@Controller
@RequestMapping(value="/bankAccount/*")
public class BankAccountController {
	
	private BankAccountDAO bankAccountDAO;
	
	public BankAccountController() {
		this.bankAccountDAO = new BankAccountDAO();
	}
	
	@RequestMapping(value="add.iu", method=RequestMethod.GET)
	public String add(BankAccountDTO bankAccountDTO, HttpSession session) throws Exception {
		System.out.println("BankAccount Add");	
		
		BankmembersDTO bankMembersDTO = (BankmembersDTO)session.getAttribute("member");
		System.out.println(bankAccountDTO.getBookNum());
		bankAccountDTO.setUserName(bankMembersDTO.getUsername());
		//bankAccountDTO.setBookNum(null);
		
		int result = this.bankAccountDAO.add(bankAccountDTO);
		
		return "redirect:../bankbook/list.iu";
	}
	
	

}
