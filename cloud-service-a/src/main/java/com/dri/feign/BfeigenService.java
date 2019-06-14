package com.dri.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "cloud-service-b")
public interface BfeigenService {

	@PostMapping("/get")
	String get(@RequestParam("param") String param);
}
