package ru.netology;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {
    //private List<Player> registeredPlayers = new ArrayList<>();
    HashMap<Integer, Player> registeredPlayers = new HashMap<>();

    public void register(Player player) {
        registeredPlayers.put(player.getId(), player);
    }
    public Player findByName(String name) {
        for (Player player : registeredPlayers.values()) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }


    //public void register(Player player) {
    //   if (!registeredPlayers.contains(player)) {
    //        registeredPlayers.add(player);
     //   }
     //}



    public int round(String playerName1, String playerName2) throws NotRegisteredException {
        try {
            Player player1 = findByName(playerName1);
            Player player2 = findByName(playerName2);

            if (player1 == null || player2 == null) {
                throw new NotRegisteredException("Один из игроков не зарегистрирован");
            }

            if (player1.strength > player2.strength) {
                return 1;
            } else if (player1.strength < player2.strength) {
                return 2;
            } else {
                return 0;
            }
        } catch (NotRegisteredException e) {

            throw e;
        }


    }


}