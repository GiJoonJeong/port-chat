package com.im.port.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.im.port.service.IChatRoomService;
import com.im.port.service.IChatUserService;
import com.im.port.service.IUserService;
import com.im.port.vo.dto.ChatRoomDto;
import com.im.port.vo.dto.ChatUserDto;
import com.im.port.vo.dto.CreateRoomDto;
import com.im.port.vo.dto.UserDto;
import com.im.port.vo.entity.ChatRoomEntity;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "*")
@Slf4j
@RequestMapping("/api/chat")
@RequiredArgsConstructor
@RestController
public class ChatRoomController {

	private final IChatRoomService chatRoomService;
	private final IUserService userService;
	private final IChatUserService chatUserService;

	// 채팅방 생성
	@PostMapping("/room")
	public ResponseEntity<?> postRoom(@RequestBody CreateRoomDto createRoomDto) throws Exception {
		
		log.info(" ##### ChatRoomController postRoom");
		UserDto userDto = userService.findUserById(createRoomDto.getUserid());
		ChatRoomDto chatRoomDto= new ChatRoomDto();
		chatRoomDto.setUserid(userDto.toEntity());
		chatRoomDto.setTitle(createRoomDto.getTitle());
		ChatRoomEntity creatRoomResult = chatRoomService.postRoom(chatRoomDto);
		log.info(" ### ChatRoomController postRoom SUCCESS");
		if (creatRoomResult.getId() >= 0){
			ChatUserDto chatUserDto= new ChatUserDto();
			chatUserDto.setUserid(chatRoomDto.getUserid());
			chatUserDto.setChatroomid(creatRoomResult);
			log.info(" ### chatUserDto : " + chatUserDto);
			log.info(" #### ChatRoomController postChatUser");
			Long postChatUserResult = chatUserService.postChatUser(chatUserDto);
			log.info(" ### postChatUserResult : " + postChatUserResult);
			return ResponseEntity.status(HttpStatus.OK).body(creatRoomResult);
		}
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("CREATE FAIL");
	}
	// 전체 채팅방 목록 반환
	@GetMapping("/rooms")
	public ResponseEntity<List<ChatRoomDto>> getAllRoomList() throws Exception {
		log.info(" ##### ChatRoomController getAllRoomList");
		List<ChatRoomDto> roomList = chatRoomService.getAllChatRooms();
		if (roomList == null || roomList.size() == 0)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		return ResponseEntity.status(HttpStatus.OK).body(roomList);
	}
	// 참여 채팅방 목록 반환
	@GetMapping("/rooms/{id}")
	public ResponseEntity<List<ChatRoomDto>> getRoomList(@PathVariable UserDto userdto) throws Exception {
		log.info(" ##### ChatRoomController getRoomList");
		log.info(" ### userdto : " + userdto);
		List<ChatRoomDto> roomList = chatRoomService.getChatRooms(userdto);
		if (roomList == null || roomList.size() == 0)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		return ResponseEntity.status(HttpStatus.OK).body(roomList);
	}

	// 특정 채팅방 정보 반환
	@GetMapping("/room/{id}")
	public ResponseEntity<ChatRoomDto> roomInfo(@PathVariable String id) throws Exception {
		log.info(" ##### ChatRoomController roomInfo");
		log.info(" ### id : " + id);
		Long chatRoomId = Long.parseLong(id);
		ChatRoomDto chatRoomDto = chatRoomService.getRoomInfo(chatRoomId);
		if (chatRoomDto == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		return ResponseEntity.status(HttpStatus.OK).body(chatRoomDto);
	}

}