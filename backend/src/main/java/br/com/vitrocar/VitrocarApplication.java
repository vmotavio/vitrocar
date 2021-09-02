package br.com.vitrocar;

import br.com.vitrocar.model.User;
import br.com.vitrocar.repository.UserRepository;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.header.writers.StaticHeadersWriter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.transaction.Transactional;

@SpringBootApplication
public class VitrocarApplication {

	@Autowired
	UserRepository userRepository;
	@Autowired
	PasswordEncoder encoder;

	public static void main(String[] args) {
		SpringApplication.run(VitrocarApplication.class, args);
	}

	@Bean
	public PasswordEncoder getPasswordEncoder(){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	@Bean
	public SmartInitializingSingleton importProcessor() {
		return () -> {
			if (userRepository.findByUsername("admin")==null) {
				User admin = new User();
				admin.setUsername("admin");
				admin.setPassword("admin");
				admin.setPassword(encoder.encode(admin.getPassword()));
				userRepository.save(admin);
			}
		};

	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry
						.addMapping("/**")
						.exposedHeaders("Content-Range")
						.allowedOrigins("*")
						.allowedHeaders("*")
						.allowedMethods("*");
			}
		};
	}
}
