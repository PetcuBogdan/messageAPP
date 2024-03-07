package org.example.medchatapi.services;

import org.example.medchatapi.dto.Conversation;
import org.example.medchatapi.dto.Message;
import org.example.medchatapi.repository.ConversationRepository;
import org.example.medchatapi.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class ConversationService {

    private final MessageRepository messageRepository;
    private final ConversationRepository conversationRepository;

    @Autowired
    public ConversationService(MessageRepository messageRepository, ConversationRepository conversationRepository) {
        this.messageRepository = messageRepository;
        this.conversationRepository = conversationRepository;
    }

    public String saveConversation(Conversation conversation) {
        conversationRepository.save(conversation);
        return "OK";
    }

    public String deleteConversation(Long id) {
        conversationRepository.deleteById(id);
        return "OK";
    }

    public List<Conversation> getAllConversations(){
        return conversationRepository.findAll();
    }

    public String saveMessage(Message message) {
        messageRepository.save(message);
        String apiUrl = "http://127.0.0.1:8001/answear";
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("message", message.getMessage());

        Object response = restTemplate.postForObject(apiUrl, requestBody, String.class);
        System.out.println("[RESPONSE] " + response);

        return "Response!";
    }
}
