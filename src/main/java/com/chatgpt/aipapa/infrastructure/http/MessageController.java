package com.chatgpt.aipapa.infrastructure.http;

// MessageController.java
import com.chatgpt.aipapa.domain.HistoryMessageAdapter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class MessageController {

    private final HistoryMessageAdapter historyMessageAdapter;

    @PostMapping(value = "/messages", consumes = "application/json", produces = "application/json")
    @PreAuthorize("hasAuthority('SCOPE_chatgpt')")
    public String processMessage(@RequestHeader(name = "userId") String userId, @RequestBody() String message) {
        // Build ChatGPT request
        //  var answer = historyMessageAdapter.askQuestion(userId,message);
        log.info("process message controller");
        // Process and return the ChatGPT response
        return "{" +
                "  \"question\": \"What is your favorite color?\"," +
                "  \"options\": [" +
                "    \"Red\"," +
                "    \"Blue\"," +
                "    \"Green\"" +
                "  ]" +
                "}";
    }

    @GetMapping(value = "/health")
    @PreAuthorize("hasAuthority('SCOPE_chatgpt')")
    public String health() {
        // Build ChatGPT request
        //  var answer = historyMessageAdapter.askQuestion(userId,message);
        log.info("Health");

        // Process and return the ChatGPT response
        return "UP";
    }
}
