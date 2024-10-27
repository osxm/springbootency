/**
* @Title: BasicApiRestController.java
* @Package com.osxm.sb.basic.controller
* @Description: TODO
* @author XM
* @date 2023年7月31日 下午11:10:03
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.sb.basic.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bapi")
public class BasicApiRestController {
	
	@RequestMapping("/hi")
	public String hi() {
		return "Hi, Basic hi";
	}
}
