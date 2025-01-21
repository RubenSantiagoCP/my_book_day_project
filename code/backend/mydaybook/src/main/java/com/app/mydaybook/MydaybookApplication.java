package com.app.mydaybook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.app.mydaybook.activities.config.ErrorCodesConfig;

@EnableConfigurationProperties(ErrorCodesConfig.class)
@SpringBootApplication
public class MydaybookApplication {

	public static void main(String[] args) {
		SpringApplication.run(MydaybookApplication.class, args);
	}

}
