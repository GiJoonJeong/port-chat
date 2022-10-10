package com.im.port.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.im.port.vo.entity.ChatMessageEntity;
 
public interface ChatMessageRepository extends JpaRepository<ChatMessageEntity, Long> {
    public List<ChatMessageEntity> findByChatroomid(Long chatRoomId); // Jpa query methods
}
