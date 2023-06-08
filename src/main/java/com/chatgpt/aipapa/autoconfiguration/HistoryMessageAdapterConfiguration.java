package com.chatgpt.aipapa.autoconfiguration;

import com.chatgpt.aipapa.domain.HistoryMessageAdapter;
import com.chatgpt.aipapa.domain.operation.AskQuestionOperation;
import com.chatgpt.aipapa.infrastructure.client.ChatGptClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class HistoryMessageAdapterConfiguration {

    @Bean
    public HistoryMessageAdapter HistoryMessageAdapter(WebClient webClient){
        return new HistoryMessageAdapter(new ChatGptClient(webClient));
    }
}
