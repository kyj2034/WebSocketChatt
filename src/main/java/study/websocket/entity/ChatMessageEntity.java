package study.websocket.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import study.websocket.dto.ChatMessageSaveDTO;

@Entity
@Getter
@Setter
@Table(name = "chat_table")
public class ChatMessageEntity {
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "chat_id")
	  private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "chatRoom_id")
    private ChatRoomEntity chatRoomEntity;
    private String writer;

    @Column
    private String message;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime sendDate;

    public static ChatMessageEntity toChatEntity(ChatMessageSaveDTO chatMessageSaveDTO, ChatRoomEntity chatRoomEntity){
    	ChatMessageEntity chatMessageEntity = new ChatMessageEntity();

        chatMessageEntity.setChatRoomEntity(chatRoomEntity);

        chatMessageEntity.setWriter(chatMessageSaveDTO.getWriter());
        chatMessageEntity.setMessage(chatMessageSaveDTO.getMessage());

        return chatMessageEntity;
    }
}
