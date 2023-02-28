package study.websocket.dto;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.web.socket.WebSocketSession;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatRoomDTO {


    private String chatMentor;
    private String roomId;
    private String name;

    private Set<WebSocketSession> sessions = new HashSet<>();
    //WebSocketSession 은 Spring 에서 Websocket Connection 이 맺어진 세션

    public static ChatRoomDTO create(String name){
        ChatRoomDTO room = new ChatRoomDTO();

        room.roomId = UUID.randomUUID().toString();
        room.name = name;
        return room;
    }
}
