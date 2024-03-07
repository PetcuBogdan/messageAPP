package org.example.medchatapi.dto;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Entity
@Table(name="messages")
@Component
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    private Long parentMessageId;
    @Column(nullable=false, unique = true)
    private Long conversationId;

    public Message(){}

    public Message(String message, Long parentMessageId, Long conversationId) {
        this.message = message;
        this.parentMessageId = parentMessageId;
        this.conversationId = conversationId;
    }
}
