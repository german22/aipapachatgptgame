package com.chatgpt.aipapa.infrastructure.http;

// MessageController.java
import com.chatgpt.aipapa.domain.HistoryMessageAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1")
@RequiredArgsConstructor
public class MessageController {

    private final HistoryMessageAdapter historyMessageAdapter;

    @PostMapping(value = "/messages", consumes="application/json")
    @PreAuthorize("hasAuthority('SCOPE_chatgpt')")
    public String processMessage(@RequestBody() String message) {
        // Build ChatGPT request
        var answer = historyMessageAdapter.askQuestion(message);

        // Process and return the ChatGPT response
        return answer;
    }
}
