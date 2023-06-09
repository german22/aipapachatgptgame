package com.chatgpt.aipapa.domain.util;

import lombok.NoArgsConstructor;
import reactor.core.publisher.Mono;

@NoArgsConstructor
public class Monos {

    public static <T> T get(Mono<T> mono) {
        var shared = mono.share();
        shared.subscribe();
        return shared.block();
    }

    public static <T> void wait(Mono<T> mono) {
        get(mono);
    }
}
