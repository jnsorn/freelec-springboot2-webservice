package com.jojoldu.book.springboot.web;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

	/* NOTE - MockMvc: 웹 API를 테스트 할 때 사용, 스프링 MVC 테스트의 시작점,
	    이 클래스를 통해 HTTP GET, POST등에 대한 API 테스트를 할 수 있다.*/
	@Autowired
	private MockMvc mvc;

	@Test
	public void hello가_리턴된다() throws Exception {
		String hello = "hello";

		/* NOTE : MockMvc를 통해 "/hello"주소로 HTTP GET 요청을 함*/
		mvc.perform(get("/hello"))
			.andExpect(status().isOk()) /* NOTE : mvc.perform의 결과를 검증, HTTP Header의 status를 검증*/
			.andExpect(content().string(hello)); /* NOTE : 응답 본문의 내용을 검증 */

	}

	@Test
	public void helloDto가_리턴된다() throws Exception {
		String name = "hello";
		int amount = 1000;

		mvc.perform(
			get("/hello/dto")
				/* NOTE : API 테스트할 때 사용될 요청 파라미터를 설정(값은 String만 허용)*/
				.param("name", name)
				.param("amount", String.valueOf(amount)))
			.andExpect(status().isOk())
			/* NOTE : Json 응답값을 필드별로 검증할 수 있는 메소드로 $을 기준으로 필드명 명시*/
			.andExpect(jsonPath("$.name", is(name)))
			.andExpect(jsonPath("$.amount", is(amount)));
	}

}