package com.boot.api;

import java.io.IOException;
import java.nio.file.Paths;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class ApiController {
	
	@Autowired
	ResourceLoader resourceLoader;
	
	@GetMapping("/ocr")
	public String ocrTest(Model model) throws IOException {
		String path=Paths.get(resourceLoader.getResource("classpath:static").getURI()).toString(); //해당하는 폴더의 위치를 가져오기
//		Paths.get(resourceLoader.getResource("classpath:static").getURI()) > 경로를 가져오고 .toString으로 문자열로 변환
		System.out.println(path);
		
		OCR ocr =new OCR();
		String res=ocr.ocrTest(path);
		model.addAttribute("res",new JSONObject(res));
		
		return "ocrRes";
	}

	//CLOVA Speech  > NAVER Cloud Platform의 CLOVA Speech는 CLOVA의 NEST(Neural End-to-end Speech Transcriber) 음성 인식 기술을 통해 빠르고 쉽게 미디어(동영상)의 음성인식을 제공
	@GetMapping("/speech")
	public String speechTest(Model model) throws IOException {
		String path=Paths.get(resourceLoader.getResource("classpath:static").getURI()).toString();
		System.out.println(path);
		
		Speech speech= new Speech();
		String res=speech.speechTest(path);
		
		model.addAttribute("res",new JSONObject(res));
		return "speechRes";
	}
}
