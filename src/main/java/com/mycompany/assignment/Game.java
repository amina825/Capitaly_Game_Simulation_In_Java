/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the game logic, including reading the game configuration,
 * playing the game, and determining the second loser.
 */
public class Game {
    public List<Field> board = new ArrayList<>();    
    public List<Player> players = new ArrayList<>();  
    public List<Integer> diceRolls = new ArrayList<>();
    public List<Player> losers = new ArrayList<>();

    public Game() {}

    /**
     * Reads the game configuration from a file.
     * 
     * @param filename the name of the file containing the game configuration
     * @throws IOException if an I/O error occurs
     */
    public void readGameFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            try {
                int numFields = Integer.parseInt(reader.readLine());
                for (int i = 0; i < numFields; i++) {
                    String[] fieldData = reader.readLine().split(" ");
                    switch (fieldData[0]) {
                        case "PropertyField":
                            board.add(new PropertyField());
                            break;
                        case "ServiceField":
                            board.add(new ServiceField(Integer.parseInt(fieldData[2])));
                            break;
                        case "LuckyField":
                            board.add(new LuckyField(Integer.parseInt(fieldData[2])));
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid field type: " + fieldData[0]);
                    }
                }
                int numPlayers = Integer.parseInt(reader.readLine());
                for (int i = 0; i < numPlayers; i++) {
                    String[] playerData = reader.readLine().split(" ");
                    Strategy strategy;
                    switch (playerData[1]) { 
                        case "Greedy":
                            strategy = new GreedyStrategy();
                            break;
                        case "Careful":
                            strategy = new CarefulStrategy();
                            break;
                        case "Tactical":
                            strategy = new TacticalStrategy();
                            break;
                        default:
                            throw new IllegalArgumentException("Unknown strategy: " + playerData[1]);
                    }
                    players.add(new Player(playerData[0], strategy));
                }
                int numRolls = Integer.parseInt(reader.readLine());
                for (int i = 0; i < numRolls; i++) {
                    diceRolls.add(Integer.parseInt(reader.readLine()));
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid number format in game file", e);
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new IllegalArgumentException("Invalid field or player definition in game file", e);
            }
        } catch (FileNotFoundException e) {
            throw new IOException("Game file not found: " + filename, e);
        }               
    }

    /**
     * Plays the game by processing dice rolls and updating player positions.
     */
    public void play() {
        for (int roll : diceRolls) {
            for (Player player : players) {
                if (!losers.contains(player)) {
                    player.move(roll, board.size());
                    board.get(player.getPosition()).landOn(player, this);
                    if (player.isBankrupt()) {
                        losers.add(player);
                        for (PropertyField property : player.getProperties()) {
                            property.setOwner(null);
                            property.setHouse(false);
                        }
                        player.getProperties().clear();
                    }
                }              
            }
            if (losers.size() >= 2) {                 
                break;
            }  
        }
    }
    
    /**
     * Returns the second player to go bankrupt.
     * 
     * @return the second loser, or null if fewer than two players have gone bankrupt
     */
    public Player getSecondLoser() {
        return losers.size() >= 2 ? losers.get(1) : null;
    } 
}