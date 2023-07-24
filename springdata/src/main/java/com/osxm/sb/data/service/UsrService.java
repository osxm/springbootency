/**
* @Title: UsrService.java
* @Package com.osxm.sb.data.service
* @Description: TODO
* @author XM
* @date 2023年7月20日 下午11:00:43
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.sb.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osxm.sb.data.dao.UsrRepository;
import com.osxm.sb.data.entity.Usr;

@Service
public class UsrService {
	
	
	@Autowired
	private UsrRepository  usrRepository;
	
	public Usr get(long id) {
		return usrRepository.getReferenceById(id);
	}
	
	
}
