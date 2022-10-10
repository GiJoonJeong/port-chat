package com.im.port.service;

import java.util.List;

import com.im.port.vo.dto.ChatRoomDto;
import com.im.port.vo.dto.UserDto;
import com.im.port.vo.entity.ChatRoomEntity;

public interface IChatRoomService {
    ChatRoomEntity postRoom(ChatRoomDto chatRoomDto) throws Exception;
    void deleteRoom(Long chatRoomId) throws Exception;
	List<ChatRoomDto> getAllChatRooms() throws Exception;
	List<ChatRoomDto> getChatRooms(UserDto userdto) throws Exception;
	ChatRoomDto getRoomInfo(Long id) throws Exception;
}
