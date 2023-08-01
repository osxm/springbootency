/**
* @Title: CityRepositoryTests.java
* @Package com.osxm.sb.data.dao
* @Description: TODO
* @author XM
* @date 2023年8月1日 下午10:30:42
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.sb.data.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.osxm.sb.data.entity.City;

@SpringBootTest
public class CityRepositoryTests {
	
	@Autowired
	private CityRepository cityRepository;
	
	@Test
	public void get() {
		City city = cityRepository.findById((long)1).get();
		System.out.println(city.getName());
	}

}
