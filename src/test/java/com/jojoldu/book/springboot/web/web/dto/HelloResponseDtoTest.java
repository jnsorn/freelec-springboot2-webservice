package com.jojoldu.book.springboot.web.web.dto;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

import com.jojoldu.book.springboot.web.dto.HelloResponseDto;

public class HelloResponseDtoTest {

	@Test
	public void 롬복_기능_테스트() {
		//given
		String name = "test";
		int amount = 1000;

		//when
		HelloResponseDto dto = new HelloResponseDto(name, amount);

		//then
		/* NOTE : assertj라는 테스트 검증 라이브러리의 검증 메소드*/
		assertThat(dto.getName()).isEqualTo(name);
		assertThat(dto.getAmount()).isEqualTo(amount);
	}
}