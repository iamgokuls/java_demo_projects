package springAnnotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config_java {

	@Bean
	public Redmi2 redmi() {
		return new Redmi2();
	}
}
