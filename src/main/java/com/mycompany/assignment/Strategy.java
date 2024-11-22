/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment;

/**
 * Defines the strategy for a player in the game.
 * Strategies determine whether a player should buy a property or build a house.
 * 
 * @author DELL
 */
public interface Strategy {
    /**
     * Determines if the player should buy a property.
     * 
     * @param player the player considering the purchase
     * @param property the property being considered
     * @return true if the player should buy, false otherwise
     */
    boolean shouldBuy(Player player, PropertyField property);

    /**
     * Determines if the player should build a house.
     * 
     * @param player the player considering building a house
     * @return true if the player should build, false otherwise
     */
    boolean shouldBuildHouse(Player player);
}
