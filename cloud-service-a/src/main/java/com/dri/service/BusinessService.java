package com.dri.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.dri.feign.BfeigenService;

@Service
public class BusinessService {
	
	@Autowired
	private BfeigenService bfeigenService;
	
	
	public String test(String param) {
		long start = System.currentTimeMillis();
		String str = bfeigenService.get(param);
		System.out.println("cost time:"+(start-System.currentTimeMillis()));
		return str;
	}

}
