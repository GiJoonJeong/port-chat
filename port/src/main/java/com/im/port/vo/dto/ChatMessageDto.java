package com.im.port.vo.dto;

import java.sql.Timestamp;

import com.im.port.vo.entity.ChatMessageEntity;
import com.im.port.vo.entity.ChatRoomEntity;
import com.im.port.vo.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatMessageDto {
    private Long id;
    private UserEntity userid;
    private ChatRoomEntity chatroomid;
    private String message;
    private Timestamp regdate;

    public ChatMessageEntity toEntity(){
        return ChatMessageEntity.builder()
                .id(id)
                .userid(userid)
                .chatroomid(chatroomid)
                .message(message)
                .regdate(regdate)
                .build();
    }    
}
