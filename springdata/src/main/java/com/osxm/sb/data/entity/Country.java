/**
* @Title: Country.java
* @Package com.osxm.sb.data.entity
* @Description: TODO
* @author XM
* @date 2023年8月24日 下午10:16:23
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.sb.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	protected Country() {

	}

	public Country(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("Country[id=%d,name=%s]", id, name);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}