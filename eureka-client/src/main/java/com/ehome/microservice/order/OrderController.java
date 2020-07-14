package com.ehome.microservice.order;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping(value="/orders")
public class OrderController {

	private Logger logger = LogManager.getLogger();
	
	@Resource
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "saveOrderInQueue")
	@RequestMapping(value="/{orderId}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Map<String, Object> saveOrder(@PathVariable("orderId") Long orderId){
		String url = "http://localhost:8085/uer/users/user-names";
		restTemplate.exchange(url, 
				HttpMethod.GET, 
				null,
				String.class);
		return null;
	}
	
	public Map<String, Object> saveOrderInQueue(@PathVariable("orderId") Long orderId){
		
		logger.debug("save order in queue");
		Map<String, Object> ret = new HashMap<>();
		ret.put("result", "save order in queue");
		return ret;
	}
}
