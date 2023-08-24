/**
* @Title: CountryRepository.java
* @Package com.osxm.sb.data.dao
* @Description: TODO
* @author XM
* @date 2023年8月24日 下午10:18:35
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.sb.data.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.osxm.sb.data.entity.Country;

public interface CountryRepository extends CrudRepository<Country, Long>{
	List<Country> findByName(String name);
}
