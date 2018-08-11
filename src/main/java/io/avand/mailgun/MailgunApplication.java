package io.avand.mailgun;

import io.avand.mailgun.config.MailGunConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({MailGunConfig.class})
public class MailgunApplication {

	public static void main(String[] args) {
		SpringApplication.run(MailgunApplication.class, args);
	}
}
