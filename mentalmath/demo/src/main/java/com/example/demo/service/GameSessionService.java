package com.example.demo.service;

import com.example.demo.model.gameSession.GameSession;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class GameSessionService {
    private Map<String, GameSession> activeGames = new HashMap<>();
    // Create a new game and return the gameId
    public String createNewGame() {
        String gameId = UUID.randomUUID().toString();
        GameSession newGameSession = new GameSession(gameId);
        activeGames.put(gameId, newGameSession);
        return gameId;
    }

    // Join an existing game
    public String joinExistingGame(String gameId, String playerId) throws Exception {
        GameSession gameSession = activeGames.get(gameId);

        if (gameSession == null) {
            throw new Exception("Game not found!");
        }

        // Add the player to the existing game
        gameSession.addPlayer(playerId);
        return gameId;
    }

    // Get the game session by gameId
    public GameSession getGameSession(String gameId) {
        return activeGames.get(gameId);
    }

    // Check if a game exists
    public boolean gameExists(String gameId) {
        return activeGames.containsKey(gameId);
    }
}

