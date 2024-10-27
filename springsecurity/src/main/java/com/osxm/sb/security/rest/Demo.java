/**
 * 
 */
package com.osxm.sb.security.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demos")
public class Demo {
	
	@RequestMapping("/hello")
	public String hello() {
		return "Hello, Spring Security";
	}

}
