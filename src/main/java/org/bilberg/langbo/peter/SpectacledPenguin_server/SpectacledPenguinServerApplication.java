package org.bilberg.langbo.peter.SpectacledPenguin_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpectacledPenguinServerApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(SpectacledPenguinServerApplication.class, args);
	}

}
