package com.example.discordbot.event;

import discord4j.core.event.domain.message.MessageCreateEvent;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class MessageCreateListener extends MessageListener implements EventListener<MessageCreateEvent> {
    @Override
    public Class<MessageCreateEvent> getEventType() {
        return MessageCreateEvent.class;
    }

    @Override
    public Mono<Void> execute(MessageCreateEvent event) {
        return processCommand(event.getMessage());
    }
}
