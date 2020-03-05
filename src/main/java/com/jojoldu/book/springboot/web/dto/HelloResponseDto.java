package com.jojoldu.book.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
/* NOTE : 모든 응답 Dto를 관리하는 클래스*/
@RequiredArgsConstructor
public class HelloResponseDto {
	private final String name;
	private final int amount;
}