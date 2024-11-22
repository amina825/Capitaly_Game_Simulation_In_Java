package com.mycompany.assignment;

/**
 * Represents a lucky field on the game board that rewards the player with money.
 */
public class LuckyField extends Field {
    
    private int reward;

    /**
     * Constructs a LuckyField with the specified reward amount.
     * 
     * @param reward the amount of money rewarded to the player
     */
    public LuckyField(int reward) {
        this.reward = reward;
    }

    /**
     * Rewards the player with the specified amount of money when they land on this field.
     * 
     * @param player the player who landed on the field
     * @param game the game instance
     */
    @Override
    public void landOn(Player player, Game game) {
        player.receiveMoney(reward);
    }
}