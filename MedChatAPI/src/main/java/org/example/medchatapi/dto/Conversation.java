package org.example.medchatapi.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="conversations")
public class Conversation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable=false, unique = true)
    private long conversationId;
    @Column(nullable=false)
    private String name;

    public Conversation() {}

    public Conversation(long conversationId, String name) {
        this.conversationId = conversationId;
        this.name = name;
    }
}

