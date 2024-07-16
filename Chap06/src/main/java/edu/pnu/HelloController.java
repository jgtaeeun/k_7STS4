package edu.pnu;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
//	@GetMapping("/Hello")
//	public void hello() {
//		//WEB-INF/board/Hello.jsp
//	}
	
	
//	@GetMapping("/Hello")
//	public String hello() {
//		//WEB-INF/board/abcd.jsp
//		return "abcd";
//	}
	
	
	@GetMapping("/Hello")
	public String hello(String name, Model model) {
		model.addAttribute("name", name);
		return "Hello";
	}
	
	
	@GetMapping("/Hello2")
	public ModelAndView hello2(String name) {
		ModelAndView mv= new ModelAndView();
		mv.addObject("name", name);
		mv.setViewName("Hello");
		return mv;
	}
}
