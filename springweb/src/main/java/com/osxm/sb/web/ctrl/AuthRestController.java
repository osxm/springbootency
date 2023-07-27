/**
* @Title: AuthRestController.java
* @Package com.osxm.sb.web.ctrl
* @Description: TODO
* @author XM
* @date 2023年7月26日 下午9:19:25
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.sb.web.ctrl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthRestController {
	
	@RequestMapping("/callback")
	public String callBack(@RequestParam String code) {
		return "获取的授权码="+code;
	}

}
