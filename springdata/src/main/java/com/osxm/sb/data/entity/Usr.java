/**
* @Title: Usr.java
* @Package com.osxm.sb.data.entity
* @Description: TODO
* @author XM
* @date 2023年7月20日 下午10:52:52
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.sb.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "USR")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
public class Usr {
	@Id
	private long id;
	
	@Column(name = "NAME")
	private String name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
