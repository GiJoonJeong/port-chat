package com.im.port.service;

import java.util.List;

import com.im.port.vo.dto.ChatMessageDto;

public interface IChatMessageService {
	List<ChatMessageDto> getMessagesByChatroomId(Long id) throws Exception;
	Long postMessage(ChatMessageDto chatMessageDto) throws Exception;
}
