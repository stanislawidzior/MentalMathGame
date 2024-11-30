package com.example.demo.webSocket;

import com.example.demo.service.GameSetup;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class MyWebSocketHandler implements WebSocketHandler {
    @Autowired
    private GameSetup gameSetup;
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    log.info("Connected");
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        HashMap<String, String> map = new ObjectMapper().readValue(message.getPayload().toString(), HashMap.class);
        log.info(map.get("type"));
        Map<String, Object> responseMap = new HashMap<>();
        String response = "";
        switch(map.get("type")){
            case "getInfo":
                responseMap.put("playerId", 10);
                responseMap.put("gameId", 10);
                response = new ObjectMapper().writeValueAsString(responseMap);
                session.sendMessage(new TextMessage(response));
                break;
            case "settings":
                responseMap = new HashMap<>();
                responseMap.put("allowedOperations",gameSetup.getGameSettings().getAllowedOperations());
                responseMap.put("gameId", 10);
                response = new ObjectMapper().writeValueAsString(responseMap);
                session.sendMessage(new TextMessage(response));
                break;
            default:
                session.sendMessage(new TextMessage("invalid message"));
                break;
        }


       //session.sendMessage(new TextMessage("Started game: " + gameId));
       Thread.sleep(1000);
       session.sendMessage(new TextMessage("Game ended"));
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        log.info("Exception occured: {} on session: {}", exception.getMessage(), session.getId());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
       log.info("Connection closed on  session {} with status {}", session.getId(), closeStatus.getCode());
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
