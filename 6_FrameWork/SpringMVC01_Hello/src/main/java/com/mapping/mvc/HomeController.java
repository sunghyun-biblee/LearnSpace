package com.mapping.mvc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mapping.mvc.dto.AddressDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	
	@RequestMapping(value="/command.do", method=RequestMethod.GET)
	public String getCommand(Model model, String name, @RequestParam("addr")String address, String phone) {
		// 모델 > 화면응답할때 필요한 데이터 / 데이터가 필요없다면 작성하지않아도된다.
		// 넘어오는 파라미터의 값을 가져오기 위해 매개변수의 이름을 파라미터의 이름과 똑같이 작성
		// 넘겨줄때 파라미터값의 이름과 받을때 매개변수의 이름이 다르면 받지 못한다. > null
		// 하지만 @RequestParam 어노테이션을 활용하여 넘어오는 파라미터값을 지정한 매개변수에 담아줄수 있다. 
		// 			>넘겨주는 파라미터의 이름과 받는 매개변수의 이름이 다르더라도 어노테이션을 사용하여 받을 수 있다.
		System.out.println(name);
		System.out.println(address);
		System.out.println(phone);
		
		model.addAttribute("dto",new AddressDto(name,address,phone));
		
		// 리턴은  [ViewResolver를 통해] 해당하는 페이지를 출력하기위해 view이름을 리턴
		return "getCommand";
	}
	
	@RequestMapping(value="/command.do", method=RequestMethod.POST)
	public String postCommand(Model model,@ModelAttribute AddressDto dto) {
		//@ModelAttribute > 객체를 만들고 담아서 전달해주세요 
		
		
//		System.out.println(dto.getName());
//		System.out.println(dto.getAddr());
//		System.out.println(dto.getPhone());
		model.addAttribute("dto",dto);
		return "postCommand";
	}
}
