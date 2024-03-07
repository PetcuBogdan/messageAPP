package org.example.medchatapi.controller;

import org.example.medchatapi.dto.Conversation;
import org.example.medchatapi.dto.Message;
import org.example.medchatapi.services.CreateConversation;
import org.example.medchatapi.services.DeleteConversation;
import org.example.medchatapi.services.GetConversations;
import org.example.medchatapi.services.SendMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.module.Configuration;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ConversationController {
    private List<Configuration> Conversations = new ArrayList<>();
    private final CreateConversation createConversation;
    private final DeleteConversation deleteConversation;
    private final GetConversations getConversations;
    private final SendMessage sendMessage;

    @Autowired
    public ConversationController(CreateConversation createConversation, DeleteConversation deleteConversation, GetConversations getConversations, SendMessage sendMessage) {
        this.createConversation = createConversation;
        this.deleteConversation = deleteConversation;
        this.getConversations = getConversations;
        this.sendMessage = sendMessage;
    }

    @PostMapping("/medChat/createConversation")
    public String createConversation(@RequestBody Conversation conversation) {
        this.createConversation.setConversation(conversation);
        return createConversation.execute();
    }

    @PostMapping("/medChat/deleteConversation")
    public String deleteConversation(@RequestBody Long id) {
        this.deleteConversation.setId(id);
        return deleteConversation.execute();
    }

    @GetMapping("/medChat/conversations")
    public List<Conversation> getConversations() {
        return getConversations.execute();
    }

    @PostMapping("medChat/message")
    public String sendMessage(@RequestBody Message message) {
        this.sendMessage.setMessage(message);
        return sendMessage.execute();
    }
}
