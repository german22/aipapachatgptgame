package com.chatgpt.aipapa.domain;

import com.chatgpt.aipapa.domain.operation.AskQuestionOperation;
import com.chatgpt.aipapa.infrastructure.client.ChatGptClient;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class HistoryMessageAdapter {

    private final AskQuestionOperation askQuestionOperation;

    public String askQuestion(String message){
        return askQuestionOperation.askQuestion(message);
    }

}
