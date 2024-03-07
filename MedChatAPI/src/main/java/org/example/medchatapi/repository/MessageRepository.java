package org.example.medchatapi.repository;

import org.example.medchatapi.dto.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
