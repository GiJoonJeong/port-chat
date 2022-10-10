package com.im.port.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.im.port.repository.ChatMessageRepository;
import com.im.port.vo.dto.ChatMessageDto;
import com.im.port.vo.entity.ChatMessageEntity;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class ChatMessageServiceImpl implements IChatMessageService {

    private final ChatMessageRepository repository;

    @Override
    public List<ChatMessageDto> getMessagesByChatroomId(Long chatRoomid) throws Exception {
        log.info(" ##### ChatMessageServiceImpl getMessagesByChatroomId");
        List<ChatMessageEntity> entityList = repository.findByChatroomid(chatRoomid);
        List<ChatMessageDto> dtoList = new ArrayList<>();
        for (ChatMessageEntity entity : entityList) {
            dtoList.add(entity.toDto());
        }
        return dtoList;
    }

    @Override
    public Long postMessage(ChatMessageDto chatMessageDto) throws Exception {
        log.info(" ##### ChatMessageServiceImpl postMessage");
        return repository.save(chatMessageDto.toEntity()).getId();
    }
    
}
