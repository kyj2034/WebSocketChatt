package study.websocket.entity;

import lombok.Getter;
import lombok.Setter;


import org.springframework.data.annotation.Id;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "chatRoom_table")
public class ChatRoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chatRoom_id")
    private Long id;

    @Column
    private String roomId;

    @Column
    private String roomName;

    @Column
    private String chatMentor;

    @OneToMany(mappedBy = "chatRoomEntity", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChatMessageEntity> chatMessageEntityList = new ArrayList<>();


    public static ChatRoomEntity toChatRoomEntity(String roomName, String roomId, String chatMentor){
        ChatRoomEntity chatRoomEntity = new ChatRoomEntity();
        chatRoomEntity.setRoomName(roomName);
        chatRoomEntity.setRoomId(roomId);
        chatRoomEntity.setChatMentor(chatMentor);
        return chatRoomEntity;
    }
	
	
}
