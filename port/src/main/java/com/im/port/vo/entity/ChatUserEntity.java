package com.im.port.vo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.im.port.vo.dto.ChatUserDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "chatuser")
public class ChatUserEntity {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chatuserid")
    private Long id;

    @ManyToOne(targetEntity = UserEntity.class, fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name="userid")
    private UserEntity userid;
    
    @ManyToOne(targetEntity = ChatRoomEntity.class, fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name="chatroomid")
    private ChatRoomEntity chatroomid;

    @ManyToOne(targetEntity = ChatMessageEntity.class, fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name="chatmessageid")
    private ChatMessageEntity chatmessageid;

    public ChatUserDto toDto(){
        return ChatUserDto.builder()
                .id(id)
                .userid(userid)
                .chatroomid(chatroomid)
                .chatmessageid(chatmessageid)
                .build();
    }
}
