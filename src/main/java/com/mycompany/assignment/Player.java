/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a player in the game.
 * Each player has a name, a strategy, a position on the board, a balance of money, and a list of properties.
 * Players can move around the board, pay rent, receive money, buy properties, and build houses.
 * They can also go bankrupt if their balance falls below zero.
 * 
 * @author DELL
 */
public class Player {
    private  String name;
    private  int money = 10000;
    private Strategy strategy;
    private int position = 0;
    private List<PropertyField> properties = new ArrayList<>();

    /**
     * Constructs a new Player with the specified name and strategy.
     * 
     * @param name the name of the player
     * @param strategy the strategy of the player
     */
    public Player(String name, Strategy strategy) {
        this.name = name;
        this.strategy = strategy;
    }

    /**
     * Moves the player a specified number of steps on the board.
     * 
     * @param steps the number of steps to move
     * @param boardSize the size of the board
     * @throws IllegalArgumentException if the board size is less than or equal to zero
     */
    public void move(int steps, int boardSize) {
        if (boardSize <= 0) {
            throw new IllegalArgumentException("Board size must be greater than zero");
        }
        position = (position + steps) % boardSize;
    }
    
    /**
     * Pays rent to another player.
     * 
     * @param owner the player to whom the rent is paid
     * @param amount the amount of rent to pay
     */
    public void payRent(Player owner, int amount) {
        if (money >= amount) {
            money -= amount;
            owner.receiveMoney(amount);
        } else {
            owner.receiveMoney(money);
            money = 0;
        }
    }

    /**
     * Pays a specified amount to the bank.
     * 
     * @param amount the amount to pay to the bank
     */
    public void payBank(int amount) {
        money -= amount;
    }

    /**
     * Receives a specified amount of money.
     * 
     * @param amount the amount of money to receive
     */
    public void receiveMoney(int amount) {
        money += amount;
    }

    /**
     * Checks if the player is bankrupt.
     * 
     * @return true if the player's balance is less than or equal to zero, false otherwise
     */
    public boolean isBankrupt() {
        return money <= 0;
    }

    /**
     * Buys a property if the player has enough money.
     * 
     * @param property the property to buy
     */
    public void buyProperty(PropertyField property) {
        if (money >= 1000) {
            money -= 1000;
            property.setOwner(this);
            properties.add(property);
        }
    }

    /**
     * Builds a house on a property if the player has enough money.
     * 
     * @param property the property on which to build a house
     */
    public void buildHouse(PropertyField property) {
        if (money >= 4000) {
            money -= 4000;
            property.setHouse(true);
        }
    }
    public List<PropertyField> getProperties(){
        return properties;
    }

    /**
     * Gets the player's current balance.
     * 
     * @return the player's current balance
     */
    public int getBalance() {
        return money;
    }
    public String getName(){
        return name;
    }
    public int getPosition(){
        return position;
    }
    public Strategy getStrategy(){
        return strategy;
    }
}