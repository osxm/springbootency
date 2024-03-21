/**
* @Title: HelloController.java
* @Package com.osxm.sb.sboauth.ctrl
* @Description: TODO
* @author XM
* @date 2024年3月21日 上午6:39:28
* @Copyright: 2024
* @version V1.0  
*/
package com.osxm.sb.sboauth.ctrl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description TODO
 * @author XM 
 * @date 2024年3月21日
 * 
 */
@RestController
public class HelloController {

	
	@GetMapping("/hello")
	public String hello() {
		return "Hell0";
	}
}
