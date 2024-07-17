package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.pnu.domain.Board;
import edu.pnu.domain.Member2;
import edu.pnu.service.BoardService;

@SessionAttributes("member")
@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
//	@GetMapping("getBoardList")
//	public String getBoardList(Model model) {
//		List<Board> boardList = new ArrayList<Board>();
//		for (Long i=1L; i<=10; i++) {
//			boardList.add(Board.builder()
//					.seq(i)
//					.title("게시판 프로그램 테스트")
//					.writer("도우너")
//					.content("게시판 프로그램 테스터입니다....")
//					.createDate(new Date())
//					.cnt(0L)
//					.build()
//					);
//		}
//		model.addAttribute("boardList", boardList);
//		return "getBoardList";
//		
//	}
	
	
	@GetMapping("/helloty")
	public String helloty(Model model) {
		model.addAttribute("helloty", "Hello_타임리프");
		return "hello";
	}
	
	@ModelAttribute("member")
	public Member2 setMember() {
		return new Member2();
	}
	
	@RequestMapping(value="/getBoardList", method= {RequestMethod.GET, RequestMethod.POST})
	public String getBoardList(@ModelAttribute("member")Member2 member, Model model, Board board) {
		
		if (member.getId()==null) {
			return "redirect:login";
		}
		List<Board> boardList = boardService.getBoardList(board);
		model.addAttribute("boardList", boardList);
		return "getBoardList";
		
	}
//	@RequestMapping(value="/getBoardList", method= {RequestMethod.GET, RequestMethod.POST})
//	public String getBoardList(Model model, Board board) {
//		
//	
//		List<Board> boardList = boardService.getBoardList(board);
//		model.addAttribute("boardList", boardList);
//		return "getBoardList";
//		
//	}
	
	
	@GetMapping("/insertBoard")
	public String insertBoardView(@ModelAttribute("member")Member2 member) {
		if (member.getId()==null) {
			return "redirect:login";
		}
		return "insertBoard";
		
	}
	//게시글 등록 처리
	@PostMapping("/insertBoard")
	public String insertBoard(@ModelAttribute("member")Member2 member,Board board) {
		if (member.getId()==null) {
			return "redirect:login";
		}
		
		boardService.insertBoard(board);
		return "redirect:getBoardList";
		
	}
	@GetMapping("/getBoard")
	public String getBoard(@ModelAttribute("member")Member2 member,Board board , Model model) {
		if (member.getId()==null) {
			return "redirect:login";
		}
		
		model.addAttribute("board",boardService.getBoard(board) );
		return "getBoard";
		
	}
	@PostMapping("/updateBoard")
	public String updateBoard(@ModelAttribute("member")Member2 member,Board board) {
		if (member.getId()==null) {
			return "redirect:login";
		}
		boardService.updateBoard(board);
		return "forward:getBoardList";
		
	}
	@GetMapping("/deleteBoard")
	public String deleteBoard(@ModelAttribute("member")Member2 member,Board board) {
		if (member.getId()==null) {
			return "redirect:login";
		}
		boardService.deleteBoard(board);
		return "forward:getBoardList";
		
	}
	
		
		
	
}

