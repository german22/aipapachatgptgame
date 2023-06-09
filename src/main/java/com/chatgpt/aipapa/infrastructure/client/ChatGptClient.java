package com.chatgpt.aipapa.infrastructure.client;

import com.chatgpt.aipapa.domain.operation.AskQuestionOperation;
import com.chatgpt.aipapa.domain.util.Monos;
import com.chatgpt.aipapa.infrastructure.client.model.ChatGptRequest;
import com.chatgpt.aipapa.infrastructure.client.model.ChatGptResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@RequiredArgsConstructor
public class ChatGptClient implements AskQuestionOperation {

    private final WebClient webClient;

    public String askQuestion(String userId, String message) {
        var request = ChatGptRequest.builder()
                .message(message)
                .build();

        var response = Monos.get(webClient.post()
                .uri("https://61c14206-6bed-408a-80e4-8b9822b6d460.mock.pstmn.io/v1/chat/completions")
                .body(BodyInserters.fromValue(request))
                .retrieve()
                .bodyToMono(ChatGptResponse.class));

        // Process and return the ChatGPT response
        return response.getMessage();
    }
}
