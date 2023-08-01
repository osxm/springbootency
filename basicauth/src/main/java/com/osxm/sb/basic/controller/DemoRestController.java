/**
* @Title: DemoRestController.java
* @Package com.osxm.sb.basic.controller
* @Description: TODO
* @author XM
* @date 2023年7月31日 下午11:08:45
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.sb.basic.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demos")
public class DemoRestController {
	
	@RequestMapping("/hi")
	public String hi() {
		return "Hi, Demo hi";
	}

}
