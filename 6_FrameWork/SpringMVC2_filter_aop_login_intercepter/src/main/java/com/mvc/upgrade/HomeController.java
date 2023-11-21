package com.mvc.upgrade;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.upgrade.model.biz.BoardBiz;
import com.mvc.upgrade.model.dto.BoardDto;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired  // 자동으로 biz 생성 (자동으로 집어넣는다)
	private BoardBiz biz;
	
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	
	@RequestMapping("/list.do")
	public String list(Model model) { 
		logger.info("SELECT LIST"); // 정보를 출력
		model.addAttribute("list",biz.selectList()); // biz.selectList()가 리턴해주는 값을 model에 저장
		
		return "mvclist"; // 이동할 뷰 페이지이름을 작성
	}
	
	@RequestMapping("/detail.do")
	public String detail(Model model,int myno) { // model 객체를 담을 곳 , myno : list페이지에서 이동할때 같이 넘겨준 데이터
		logger.info("SELECT ONE"); // 단순 확인용 (컨트롤러로 요청이 잘 들어왔는지, 메소드가 잘 들어왔는지)
		model.addAttribute("dto",biz.selectOne(myno));
		
		
		return "mvcdetail";
	}
	
	@RequestMapping("/insertform.do")
	public String insertForm() {
		logger.info("INSERT FORM");
		
		return "mvcinsert";
	}
	@RequestMapping("/insertres.do")
	public String insertRes(BoardDto dto) { //해당하는 객체에 값을 채워넣어서 받겠다.
		logger.info("INSERT RES");
		int res=biz.insert(dto);
		
		if(res>0) {
			return "redirect:list.do"; // mvclist를 작성하게되면 model이 list데이터를 받아 화면에 출력하게되는데 list라는 데이터가 없이 이동하기떄문에 오류가 발생한다
							  		   // list.do를 리턴하게되면 WEB-INF/views/list.do.jsp 로 호출되기때문에 오류발생 > DispatcherServlet 은 viewResolver로 보냄 > servlet-context.xml을 거쳐감
									   // redirect : list.do를 핸들러맵핑에서 다시 어떤 컨트롤로 처리하나 재탐색 후 해당 하는 컨트롤러의 메소드가 동작 (메소드 재시작)
		}else {
			return "redirect: insertform.do";
		}
		
	}
	@RequestMapping("/updateform.do")
	public String updateForm(Model model, int myno) {
		logger.info("UPDATE FORM");
		
		model.addAttribute("dto", biz.selectOne(myno));
		return "mvcupdate";
	}
	
	@RequestMapping("/updateres.do")
	public String updateRes(BoardDto dto) {
		logger.info("UPDATE RES");
		
		int res = biz.update(dto);
		if(res>0) {
			return "redirect:detail.do?myno="+dto.getMyno();
		}else {
			return "redirect:updateform.do?myno="+dto.getMyno();
		}
	}
	
	@RequestMapping("/delete.do")
	public String delete(int myno) {
		logger.info("DELETE");
		int res = biz.delete(myno);
		
		if(res>0) {
			return "redirect:list.do";
		}else {
			return "redirect:detail.do?myno="+myno;
		}
	}
}
