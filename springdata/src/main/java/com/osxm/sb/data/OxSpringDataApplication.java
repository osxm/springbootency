/**
 @Title: OxSpringDataApplication.java
* @Package com.osxm.sb.data
* @Description: TODO
* @author XM
* @date 2023年7月19日 下午8:32:33
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.sb.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.osxm.sb.data.dao.CountryRepository;
import com.osxm.sb.data.entity.Country;


@SpringBootApplication
public class OxSpringDataApplication {
	
	private static final Logger log = LoggerFactory.getLogger(OxSpringDataApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(OxSpringDataApplication.class, args);
	}

	
	@Bean
	public CommandLineRunner demo(CountryRepository repository) {
		return (args) -> {
			repository.save(new Country("China"));
			log.info("-------------------------------");
			 repository.findByName("China").forEach(china -> {
			        log.info(china.toString());
			 });
		};
	}
}
