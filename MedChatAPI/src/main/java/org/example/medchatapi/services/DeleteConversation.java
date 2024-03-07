package org.example.medchatapi.services;

import lombok.Setter;
import org.example.medchatapi.dto.Conversation;
import org.springframework.stereotype.Component;


@Component
public class DeleteConversation implements Command<String>{
    private final ConversationService conversationService;
    @Setter
    private Long id;

    public DeleteConversation(ConversationService conversationService) {
        this.conversationService = conversationService;
    }

    @Override
    public String execute() {
        return conversationService.deleteConversation(id);
    }
}
