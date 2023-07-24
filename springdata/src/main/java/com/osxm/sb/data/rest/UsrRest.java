/**
* @Title: UsrRest.java
* @Package com.osxm.sb.data.rest
* @Description: TODO
* @author XM
* @date 2023年7月20日 下午11:08:19
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.sb.data.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osxm.sb.data.dao.UsrRepository;
import com.osxm.sb.data.entity.Usr;

@RestController
@RequestMapping("/users")
public class UsrRest {

	
	@Autowired
	private UsrRepository  usrRepository;
	
	@RequestMapping("/{id}")
	public Usr get(@PathVariable long id) {
		return usrRepository.getReferenceById(id);
	}
}
