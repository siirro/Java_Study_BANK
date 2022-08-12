package com.iu.start.board;

import java.util.ArrayList;

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
	
	
	/*1. 글목록보기(list)
	URL       : /board/list.확장자    -- 확장자는 개발자 마음대로
	Method    : GET
	JSP       : /WEB-INF/views/board/list.jsp
	Parameter : 없음
	*/
	
	@RequestMapping(value="list.iu", method=RequestMethod.GET)
	public String list(Model model)throws Exception{
		
		ArrayList<BoardDTO> ar = boardDAO.getlist();
		
		model.addAttribute("list", ar);
		return "./board/list";
		
	}

}
