/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment;

/**
 * Represents an abstract field on the game board.
 * Subclasses should implement the landOn method to define
 * what happens when a player lands on the field.
 * 
 * @author DELL
 */
public abstract class Field {
    /**
     * Defines the action to be taken when a player lands on the field.
     * 
     * @param player the player who landed on the field
     * @param game the game instance
     */
    public abstract void landOn(Player player, Game game);
}
