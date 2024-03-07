package org.example.medchatapi.services;

import lombok.Setter;
import org.example.medchatapi.dto.Conversation;
import org.springframework.stereotype.Component;

@Component
public class CreateConversation implements Command<String>{
    private final ConversationService conversationService;
    @Setter
    private Conversation conversation;

    public CreateConversation(ConversationService conversationService) {
        this.conversationService = conversationService;
    }

    @Override
    public String execute() {
        return conversationService.saveConversation(conversation);
    }
}
