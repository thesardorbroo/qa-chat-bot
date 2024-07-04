package uz.sardorbroo.qa.config;

import lombok.extern.slf4j.Slf4j;
import org.devlive.sdk.openai.OpenAiClient;
import org.devlive.sdk.openai.listener.ConsoleEventSourceListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import uz.sardorbroo.qa.config.properties.OpenAiProperties;

import java.util.concurrent.CountDownLatch;

@Slf4j
@Configuration
public class OpenAiConfig {

    @Bean
    public OpenAiClient initClient(OpenAiProperties properties) {
        log.info("Configuring OpenAi client...");

        CountDownLatch countDownLatch = new CountDownLatch(1);
        ConsoleEventSourceListener listener = ConsoleEventSourceListener.builder()
                .countDownLatch(countDownLatch)
                .build();

        OpenAiClient client = OpenAiClient.builder()
                .apiHost(properties.getHost())
                .apiKey(properties.getKey())
                .listener(listener)
                .build();

        log.info("OpenAi client is configured successfully");
        return client;
    }
}
