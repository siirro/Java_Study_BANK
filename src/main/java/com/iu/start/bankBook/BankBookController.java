package com.iu.start.bankBook;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.start.bankBook.BankBookDTO;

@Controller
@RequestMapping(value="/bankbook/*")
public class BankBookController {
	
	@RequestMapping(value="delete.iu", method=RequestMethod.GET)
	public ModelAndView delete(BankBookDTO bankbookDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println("딜리트");
		BankBookDAO bankbookDAO = new BankBookDAO();
		int result = bankbookDAO.setDelete(bankbookDTO);
		
		mv.setViewName("redirect:./list.iu");
		return mv;
		
		//return "redirect:./list";
	}
	
	@RequestMapping(value="update.iu", method = RequestMethod.GET)
	public void update(BankBookDTO bankbookDTO, Model model) throws Exception{
		//BankBookDAO bankbookDAO = new BankBookDAO();
		System.out.println("업데이트 페이지 실행");
		BankBookDAO bankbookDAO = new BankBookDAO();
	
		bankbookDTO = bankbookDAO.getDetail(bankbookDTO);
		model.addAttribute("update", bankbookDTO);
		
	}
	
//	@RequestMapping(value="update", method = RequestMethod.POST)
//	public ModelAndView update(BankBookDTO bankbookDTO) throws Exception{
//		ModelAndView mv = new ModelAndView();
//		BankBookDAO bankbookDAO = new BankBookDAO();
//		//bankbookDTO = bankbookDAO.getDetail(bankbookDTO);
//		
//		int result = bankbookDAO.setUpdate(bankbookDTO);
//		
//		mv.setViewName("redirect:./list");
//		//mv.addObject("update", bankbookDTO);
//		
//		return mv;
//	}
	
	@RequestMapping(value="update.iu", method = RequestMethod.POST)
	public String update(BankBookDTO bankbookDTO) throws Exception{
		
		BankBookDAO bankbookDAO = new BankBookDAO();
		
		int result = bankbookDAO.setUpdate(bankbookDTO);
		
		return "redirect:./detail.iu?booknum="+bankbookDTO.getBooknum();
	}
	
	
	// /bankbook/list  Get   list()
	
	@RequestMapping(value="list.iu", method = RequestMethod.GET)
	public String list(Model model) throws Exception {
		System.out.println("list 실행");
		BankBookDAO bankbookDAO = new BankBookDAO();
		ArrayList<BankBookDTO> ar = bankbookDAO.getList();
		
		/*
		ArrayList<BankBookDTO> ar = new ArrayList<BankBookDTO>();
		for(int i=0;i<10;i++) {
			BankBookDTO bankbookDTO = new BankBookDTO();
			bankbookDTO.setBookname("bookname"+i);
			bankbookDTO.setBooknum((long)i);
			bankbookDTO.setBookrate(Math.random());
			bankbookDTO.setBooksale(1);
			ar.add(bankbookDTO);
		}
		*/
		
		model.addAttribute("list", ar);
		return "bankbook/list";
	}
	
	// /bankbook/detail Get detail()
	
	@RequestMapping(value="detail.iu", method = RequestMethod.GET)
	public ModelAndView detail(BankBookDTO bankbookDTO) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		BankBookDAO bankbookDAO = new BankBookDAO();
		System.out.println("detail 실행");

		bankbookDTO = bankbookDAO.getDetail(bankbookDTO);
		//return "bankbook/detail";
		
		/*db가없는사람
		bankbookDTO.setBookname("name");;
		bankbookDTO.setBookrate(3.12);
		bankbookDTO.setBooksale(1);
		*/
		
		mv.setViewName("bankbook/detail");
		mv.addObject("detail", bankbookDTO);
		
		return mv;
	}
	
	
	
	// /bankbook/add GET  /WEB-INF/views/bankbook/add.jsp
	@RequestMapping(value="add.iu", method = RequestMethod.GET)
	public void add() {
		
		System.out.println("add 실행 get");
		//return "bankbook/add";
	}
	
	@RequestMapping(value="add.iu", method = RequestMethod.POST)
	public ModelAndView add(BankBookDTO bDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println("add 실행 post");
		BankBookDAO bankbookDAO = new BankBookDAO();
		int check = bankbookDAO.setBankBook(bDTO);
		System.out.println(check);
		mv.setViewName("redirect:./list.iu");


		
		return mv;
		//return "redirect:./list";
	}
	
	
}
