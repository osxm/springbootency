package com.osxm.sb.encyproperties;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.io.ClassPathResource;
import org.yaml.snakeyaml.Yaml;

import com.osxm.sb.encyproperties.config.EncryptedPropertySource;

@SpringBootApplication
public class EncypropertiesApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(EncypropertiesApplication.class);
		application.addInitializers(new ApplicationContextInitializer<ConfigurableApplicationContext>() {
			@Override
			public void initialize(ConfigurableApplicationContext applicationContext) {
				ConfigurableEnvironment environment = applicationContext.getEnvironment();
				try (InputStream input = new ClassPathResource("application.yml").getInputStream()) {
					Yaml yaml = new Yaml();
					Map<String, Object> yamlProperties = yaml.load(input);
					Map<String, Object> flattenedProperties = new HashMap<>();
					flattenMap(yamlProperties, flattenedProperties, null);
					EncryptedPropertySource encryptedPropertySource = new EncryptedPropertySource("encryptedProperties",
							flattenedProperties);
					environment.getPropertySources().addFirst(encryptedPropertySource);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			private void flattenMap(Map<String, Object> source, Map<String, Object> target, String path) {
				source.forEach((key, value) -> {
					String fullPath = (path == null ? key : path + "." + key);
					if (value instanceof Map) {
						flattenMap((Map<String, Object>) value, target, fullPath);
					} else {
						target.put(fullPath, value);
					}
				});
			}
		});
		application.run(args);
	}

}
