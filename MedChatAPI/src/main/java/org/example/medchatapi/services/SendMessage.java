package org.example.medchatapi.services;

import lombok.Setter;
import org.example.medchatapi.dto.Message;
import org.springframework.stereotype.Component;


@Component
public class SendMessage implements Command<String>{
    private final ConversationService conversationService;
    @Setter
    private Message message;

    public SendMessage(ConversationService conversationService, Message message) {
        this.conversationService = conversationService;
        this.message = message;
    }

    @Override
    public String execute() {
        return conversationService.saveMessage(message);
    }
}
