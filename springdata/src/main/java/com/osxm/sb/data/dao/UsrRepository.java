/**
* @Title: UsrRepository.java
* @Package com.osxm.sb.data.dao
* @Description: TODO
* @author XM
* @date 2023年7月20日 下午11:01:37
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.sb.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.osxm.sb.data.entity.Usr;

public interface UsrRepository extends JpaRepository<Usr, Long>{

}
