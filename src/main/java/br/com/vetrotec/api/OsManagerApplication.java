package br.com.vetrotec.api;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import br.com.vetrotec.api.config.property.OsManagerApiProperty;

@SpringBootApplication
@EnableConfigurationProperties(OsManagerApiProperty.class)
public class OsManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OsManagerApplication.class, args);
	}
	
	@PostConstruct 
	public void init(){
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}

}
