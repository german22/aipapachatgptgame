package com.chatgpt.aipapa.domain;

import com.chatgpt.aipapa.domain.operation.AskQuestionOperation;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class HistoryMessageAdapter {

    private final AskQuestionOperation askQuestionOperation;

    public String askQuestion(String userId, String message) {
        return askQuestionOperation.askQuestion(userId, message);
    }

}
