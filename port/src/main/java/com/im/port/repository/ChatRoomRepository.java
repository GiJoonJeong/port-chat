package com.im.port.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.im.port.vo.dto.UserDto;
import com.im.port.vo.entity.ChatRoomEntity;

public interface ChatRoomRepository extends JpaRepository<ChatRoomEntity, Long> {
    
    public Optional<ChatRoomEntity> findById(Long id);
    
    @Query(value = " SELECT a.* "
                 + " FROM chatroom a, chatuser b "
                 + " WHERE 1=1 "
                 + " AND a.chatroomid = b.chatroomid "
                 + " AND b.chatuserid = :id ", nativeQuery = true)
    public List<ChatRoomEntity> selectSQLByUserid(@Param(value = "id") Long id);
    public List<ChatRoomEntity> findByUserid(UserDto userDto);;

}
