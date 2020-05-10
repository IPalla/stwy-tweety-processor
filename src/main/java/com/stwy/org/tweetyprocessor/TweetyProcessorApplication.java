package com.stwy.org.tweetyprocessor;

import com.stwy.org.tweetyprocessor.messaging.TweetProcessedOutput;
import com.stwy.org.tweetyprocessor.messaging.TweetStreamerInput;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@EnableJpaAuditing
@EnableJpaRepositories
@EnableTransactionManagement
@EnableFeignClients
@EnableBinding({
		TweetProcessedOutput.class,
		TweetStreamerInput.class
})
public class TweetyProcessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(TweetyProcessorApplication.class, args);
	}

}
