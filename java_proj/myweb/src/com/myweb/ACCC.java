package com.myweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/aaa")

public class ACCC {
	@RequestMapping(value="/bbb",method=(RequestMethod.GET))
	public String test(){
		return "xxx";
	}
}
