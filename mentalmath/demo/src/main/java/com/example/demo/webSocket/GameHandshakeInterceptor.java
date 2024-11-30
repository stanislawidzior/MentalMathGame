package com.example.demo.webSocket;

import com.example.demo.service.GameService;
import com.example.demo.service.GameSessionService;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.Map;
@Component
public class GameHandshakeInterceptor implements HandshakeInterceptor {
   private GameSessionService gameSessionService;
   public GameHandshakeInterceptor(GameSessionService gameSessionService){
       this.gameSessionService = gameSessionService;
   }

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {

//       var gameId = request.getHeaders().get("gameId");
//        var userId = request.getHeaders().get("playerId");
//        if(gameId == null || userId == null){
//            throw new IllegalArgumentException("game Id and player Id are required");
//        }
//        attributes.put("gameId", gameId.get(0));
//        attributes.put("playerId", userId.get(0));
        return true;


    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {
        if(exception != null){
            exception.printStackTrace();
        }else{
            System.out.println("Succesful handshake");
        }

    }
}
