package com.chatgpt.aipapa.infrastructure.client.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ChatGptResponse {

    private final String message;
}
