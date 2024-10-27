/**
* @Title: CityRest.java
* @Package com.osxm.sb.data.rest
* @Description: TODO
* @author XM
* @date 2023年8月1日 下午11:15:04
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.sb.data.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osxm.sb.data.dao.CityRepository;
import com.osxm.sb.data.entity.City;

@RestController
public class CityRest {
	
	@Autowired
	private CityRepository cityRepository;
	
	@RequestMapping("/citys/{id}")
	public City get(@PathVariable String id) {
		return cityRepository.findById(Long.valueOf(id)).get();
	}

}
