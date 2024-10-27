/**
* @Title: CityRepository.java
* @Package com.osxm.sb.data.dao
* @Description: TODO
* @author XM
* @date 2023年8月1日 下午10:24:28
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.sb.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.osxm.sb.data.entity.City;

public interface CityRepository extends JpaRepository<City, Long>{

}
