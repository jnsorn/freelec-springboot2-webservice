package com.jojoldu.book.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
/* NOTE : 페이지와 관련된 컨트롤러*/
@Controller
public class IndexController {
	@GetMapping("/")
	public String index(){
		return "index";
	}

	@GetMapping("/posts/save")
	public String postsSave(){
		return "posts-save";
	}
}
