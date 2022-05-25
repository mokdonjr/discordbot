package com.example.discordbot.event;

import discord4j.core.object.entity.Message;
import reactor.core.publisher.Mono;

public abstract class MessageListener {

//    static Map<String, Consumer<MessageChannel>> map = new HashMap<>();
//    static {
//        map.put("!image", messageChannel -> messageChannel.createMessage(EmbedCreateSpec.builder()
//                .color(Color.BLUE)
//                .title("Title")
//                .url("https://discord4j.com")
//                .author("Some Name", "https://discord4j.com", "https://i.imgur.com/F9BhEoz.png")
//                .description("a description")
//                .thumbnail("https://i.imgur.com/F9BhEoz.png")
//                .addField("field title", "value", false)
//                .addField("\u200B", "\u200B", false)
//                .addField("inline field", "value", true)
//                .addField("inline field", "value", true)
//                .addField("inline field", "value", true)
//                .image("https://i.imgur.com/F9BhEoz.png")
//                .timestamp(Instant.now())
//                .footer("footer", "https://i.imgur.com/F9BhEoz.png")
//                .build()));
//        map.put("!text", messageChannel -> messageChannel.createMessage("Things to do today:\\n - write a bot\\n - eat lunch\\n - play a game"));
//    }

    public Mono<Void> processCommand(Message eventMessage) {

//        if (eventMessage.getAuthor().map(u -> !u.isBot()).orElse(false)) {
//            String content = eventMessage.getContent();
//            if (map.containsKey(content)) {
//                map.get(content).accept(eventMessage.getChannel());
//            }
//        }

        return Mono.just(eventMessage)
                .filter(message -> message.getAuthor().map(user -> !user.isBot()).orElse(false))
                .filter(message -> message.getContent().equalsIgnoreCase("!todo"))
                .flatMap(Message::getChannel)
                .flatMap(channel -> channel.createMessage("Things to do today:\n - write a bot\n - eat lunch\n - play a game"))
                .then();
    }
}
