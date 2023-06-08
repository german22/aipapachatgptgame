package com.chatgpt.aipapa.infrastructure.client.model;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@Getter
@RequiredArgsConstructor
public class ChatGptRequest {

    private final String message;
}
