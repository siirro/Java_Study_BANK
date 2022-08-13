package com.iu.start.board;

import java.net.http.HttpRequest;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/board/*")
public class BoardController {
	
	private BoardDAO boardDAO;
	
	public BoardController() {
		this.boardDAO = new BoardDAO();
	}
	
	@RequestMapping(value="list.iu", method=RequestMethod.GET)
	public String list(Model model)throws Exception{
		
		ArrayList<BoardDTO> ar = boardDAO.getlist();
		
		model.addAttribute("list", ar);
		return "./board/list";
		
	}
	
	@RequestMapping(value="detail.iu", method=RequestMethod.GET)
	public String detail(BoardDTO boardDTO, Model model)throws Exception {
		boardDTO = boardDAO.getDetail(boardDTO);
		
		model.addAttribute("detail", boardDTO);
		
		return "board/detail";
	}
	
	@RequestMapping(value="add.iu", method=RequestMethod.GET)
	public String add()throws Exception{
		
		
		return "board/add";
	}
	
	@RequestMapping(value="add.iu", method=RequestMethod.POST)
	public String add(BoardDTO boardDTO)throws Exception{
		
		int result = boardDAO.add(boardDTO);
		
		return "redirect:./list.iu";
	}
	
	@RequestMapping(value="update.iu", method=RequestMethod.GET)
	public void update(BoardDTO boardDTO, Model model)throws Exception {
		model.addAttribute("update", boardDTO);
		
	}
	
	@RequestMapping(value="update.iu", method=RequestMethod.POST)
	public String update(HttpServletRequest request, BoardDTO boardDTO)throws Exception {
		int result = boardDAO.update(boardDTO);
		
		return "redirect:./list.iu";
	}
	
	@RequestMapping(value="delete.iu", method=RequestMethod.GET)
	public String delete(BoardDTO boardDTO)throws Exception{
		
		int result = boardDAO.delete(boardDTO);
		return "redirect:list.iu";
	}

}
