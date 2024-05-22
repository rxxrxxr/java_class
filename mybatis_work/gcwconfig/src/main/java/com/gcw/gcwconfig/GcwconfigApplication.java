package com.gcw.gcwconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class GcwconfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(GcwconfigApplication.class, args);
	}

}
