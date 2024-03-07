package org.example.medchatapi.services;

import org.example.medchatapi.dto.Conversation;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetConversations implements Command<List<Conversation>>{
    private final ConversationService conversationService;

    public GetConversations(ConversationService conversationService) {
        this.conversationService = conversationService;
    }

    @Override
    public List<Conversation> execute() {
        return conversationService.getAllConversations();
    }
}
