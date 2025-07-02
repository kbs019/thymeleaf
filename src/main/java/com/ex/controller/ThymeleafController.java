package com.ex.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/th/*")	// get 방식 + post 방식 --  class 에 연결이 되어있다면 루트 주소로 사용됨
public class ThymeleafController {	// http://localhost:8080/th/*
	
	@GetMapping("main")		// http://localhost:8080/th/main
	public String main() {
		return "main";
	}
	
	@GetMapping("ex01")		// http://localhost:8080/th/ex01  의 uri 가 요청되었을 때, ex01.html 로 연결한다.
	public String ex01( Model model ) {		// 전달할 값이 있다면 model 에 넣어 보낸다.
		// view 페이지에 데이터를 전달한다.	-- 뷰 페이지에서 message 라는 이름으로 값을 꺼내어 사용
		model.addAttribute("message", "Hello Thymeleaf");
		return "ex01";
	}
	
	@GetMapping("ex02")		// http://localhost:8080/th/ex02 라는 요청이 오면 ex02() 를 실행하여
	public String ex02( Model model ) {
		// view 페이지로 전달한다.
		//message 속성에 "<h1>Hello Thymeleaf</h1>" 문자열을 담아서 전달
		model.addAttribute("message", "<h1>Hello Thymeleaf</h1>");
		model.addAttribute("htmlContent", "<h1>Hello Thymeleaf</h1>");
		
		return "ex02";		// ex02.html  로 이동한다.
	}
	
	@GetMapping("ex03")
	public String ex03() {
		return "ex03";
	}
	
	@GetMapping("ex04")
	public String ex04( Model model ) {
		model.addAttribute("date", new Date());
		model.addAttribute("num", 100000);
		model.addAttribute("num2", 0.12345);
		model.addAttribute("message", "Hello Thymeleaf");
		
		List<String> list = new ArrayList<String>();
		list.add("java");
		list.add("web");
		list.add("sql");
		list.add("jsp");
		list.add("spring");
		
		model.addAttribute("list", list);
		
		return "ex04";		// ex04.html
	}
	
	@GetMapping("ex05")
	public String ex05( Model model ) {
		model.addAttribute("data", "main");
		
		return "ex05";		// ex05.html
	}
	
	// 0702
	// 타임리프에서의 세션값 처리하는 방법 확인
	@GetMapping("ex06")
	public String ex06( HttpSession session ) {
		User user = new User();
		user.setName("타임리프");
		user.setAge(20);
		
		// 세션을 사용하면 모델은 필요 없음
		session.setAttribute("user", user);
		
		return "ex06";	// 뷰 페이지의 주소 ex06.html
	}
	
	@GetMapping("ex07")		// http://localhost:8080/th/ex07 이라는 uri 를 요청받았을 때, ex07 이 uri 에 노출되었으므로 get 방식
	public String ex07() {
		return "ex07";		// 템플릿/ex07.html 이라는 뷰 페이지
	}
	
	// 타임리프에서 파라미터 사용해보기
	@GetMapping("ex08")
	public String ex08() {
		return "ex08";
	}
	
	@GetMapping("ex09")
	public String ex09( HttpSession session ) {		// MVC 가 자동으로 주입해준다. 					나중에 할 것임 DI(의존성 주입)
		session.setAttribute("sid", "stringboot");
		return "ex09";
	}
/*
	스피링 MVC 에서 자동으로 주입해주는 객체
		HttpServletRequest		: jsp 에서 사용했던 request
		HttpServletResponse		: jsp 에서 사용했던 response
		HttpSesssion			: session
		Principal				: 스프링 시큐리티에서 사용되는 인증된 사용자 정보
		Model					: 컨트롤러에서 뷰로 데이터를 전달할 때, 사용하는 객체
		ModelMap				: Model 과 비긋한 역할 Map 인터페이스를 구현한 객체
		RedirectAttribute		: 기본적인 리다이렉트는 데이터 전달 불가, 하지만 Attribute 가 붙으므로 리다이렉트 시 데이터 전달할 때 사용
		BindingResult			: 폼 데이터와 바인딩 결과와 검증할 유효성 검사에 사용
		MultipartFile			: 파일 업로드를 처리하는 객체
*/
	
	// 타임리프 if 문 사용
	@GetMapping("ex10")
	public String ex10( Model model ) {
		model.addAttribute("age", 70);
		return "ex10";
	}
	
	// 타임리프 switch 문 사용
	@GetMapping("ex11")
	public String ex11( Model model ) {
		model.addAttribute("age", 20);
		return "ex11";
	}
	
	// 타임리프 반복문 사용
	@GetMapping("ex12")
	public String ex12( Model model ) {
		List<String> list = Arrays.asList("java", "sql", "jsp", "spring", "thymeleaf");
		model.addAttribute("list", list);
		
		List<User> userList = new ArrayList<User>();
		userList.add(new User("java", 20));
		userList.add(new User("sql", 30));
		userList.add(new User("jsp", 40));
		userList.add(new User("spring", 50));
		userList.add(new User("thymeleaf", 60));
		model.addAttribute("userList", userList);
		return "ex12";
	}
	
	@GetMapping("ex13")
	public String ex13( Model model ) {
		model.addAttribute("age", 10);
		return "ex13";
	}
	
	@GetMapping("ex14")
	public String ex14(Model model) {
		model.addAttribute("image", "default.jpg");
		return "ex14";
	}
	
	@GetMapping("ex15")
	public String ex15() {
		return "ex15";
	}
	
	// http://localhost:8080/th/memberForm
	@GetMapping("memberForm")
	public String form() {
		return "signUpForm";
	}
	
	@PostMapping("memberPro")
	public String pro( Member member, Model model ) {	// 매개변수로 Member member 를 넣음으로서 setter() 가 진행된 것이다.
		model.addAttribute("msg", "회원가입이 완료되었습니다.");
		model.addAttribute("member", member);
		return "signUpPro";
	}
}