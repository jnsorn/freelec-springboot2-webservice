package com.jojoldu.book.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jojoldu.book.springboot.service.posts.PostsService;
import lombok.RequiredArgsConstructor;

/* NOTE : 페이지와 관련된 컨트롤러*/
@RequiredArgsConstructor
@Controller
public class IndexController {
	private final PostsService postsService;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("posts", postsService.findAllDesc());
		return "index";
	}
}
