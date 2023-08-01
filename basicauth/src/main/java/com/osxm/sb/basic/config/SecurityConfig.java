/**
* @Title: SecurityConfig.java
* @Package com.osxm.sb.basic
* @Description: TODO
* @author XM
* @date 2023年7月31日 下午10:24:02
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.sb.basic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// @formatter:off
		http.antMatcher("/bapi/**").authorizeHttpRequests((authorize) -> authorize
			.anyRequest().authenticated()).httpBasic(withDefaults());  // 只处理了/bapi的请求，其他请求放行了
		// @formatter:on
		return http.build();
	}

	// @formatter:off
	@Bean
	public InMemoryUserDetailsManager userDetailsService() {
		UserDetails user = User.withDefaultPasswordEncoder()
				.username("user")
				.password("password")
				.roles("USER")
				.build();
		return new InMemoryUserDetailsManager(user);
	}
	// @formatter:on

}
