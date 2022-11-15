package com.apress.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Siva
 *
 */

@SpringBootApplication
public class SpringbootThymeleafSecurityDemoApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(SpringbootThymeleafSecurityDemoApplication.class, args);
		System.out.println(	new BCryptPasswordEncoder().encode("admin"));
	}

}
