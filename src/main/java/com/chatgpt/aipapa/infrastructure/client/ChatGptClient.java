package com.chatgpt.aipapa.infrastructure.client;

import com.chatgpt.aipapa.domain.operation.AskQuestionOperation;
import com.chatgpt.aipapa.infrastructure.client.model.ChatGptRequest;
import com.chatgpt.aipapa.infrastructure.client.model.ChatGptResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@RequiredArgsConstructor
public class ChatGptClient implements AskQuestionOperation {

    private final WebClient webClient;

    public String askQuestion(String message) {
        var request = ChatGptRequest.builder()
                .message(message)
                .build();

        var response = webClient.post()
                .uri("https://mock/api.chatgpt.com/completion")
                .body(BodyInserters.fromValue(request))
                .retrieve()
                .bodyToMono(ChatGptResponse.class)
                .block();

        // Process and return the ChatGPT response
        return response.getMessage();
    }
}
