package kr.co.ch09.controller;


import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.ch09.vo.BookVO;
import kr.co.ch09.vo.BooksVO;

@Controller
public class BookController {
	
	@GetMapping("/book/list")
	public String list(String text) {
		
		// 네이버 open API 헤더 설정
		String clientId = "c8qCcMI9g7WQtaY9wwJ9"; //애플리케이션 클라이언트 아이디
        String clientSecret = "JvX6UW9mLk"; //애플리케이션 클라이언트 시크릿
        
		String apiURL = "https://openapi.naver.com/v1/search/book.json?query={text}" + text;    // JSON 결과
		
		URI uri = UriComponentsBuilder
				.fromUriString("https://openapi.naver.com")
				.path("/v1/search/book.json")
				.queryParam("query", text)
				.queryParam("display", 10)
				.queryParam("start", 1)
				.queryParam("sort", "sim")
				.encode()
				.build()
				.toUri();
		
		RequestEntity<Void> req = RequestEntity
									.get(uri)
									.header("X-Naver-Client-Id", clientId)
									.header("X-Naver-Client-Secret", clientSecret)
									.build();
									
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<String> result = restTemplate.exchange(req, String.class);
		
		System.out.println(result);
		
		// JSON 파싱
		ObjectMapper om = new ObjectMapper();
		// BooksVO books = om.readValues(result, BooksVO.class);
        
		return "/book/list";
		
	}
	
}
