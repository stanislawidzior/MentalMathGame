package com.example.demo.model.gameSession;

import java.util.HashSet;
import java.util.Set;
 public class GameSession {
        private String gameId;
        private Set<String> players;

        public GameSession(String gameId) {
            this.gameId = gameId;
            this.players = new HashSet<>();
        }

        public String getGameId() {
            return gameId;
        }

        public Set<String> getPlayers() {
            return players;
        }

        public void addPlayer(String playerId) {
            players.add(playerId);
        }

        public void removePlayer(String playerId) {
            players.remove(playerId);
        }
    }
