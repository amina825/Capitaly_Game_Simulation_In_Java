package com.mycompany.assignment;

/**
 * Implements a strategy where the player buys properties and builds houses
 * if they have enough money.
 */
public class GreedyStrategy implements Strategy {

    /**
     * Determines if the player should buy a property.
     * 
     * @param player the player considering the purchase
     * @param property the property being considered
     * @return true if the player has at least 1000 money, false otherwise
     */
    @Override
    public boolean shouldBuy(Player player, PropertyField property) {
        return player.getBalance() >= 1000;
    }

    /**
     * Determines if the player should build a house.
     * 
     * @param player the player considering building a house
     * @return true if the player has at least 4000 money, false otherwise
     */
    @Override
    public boolean shouldBuildHouse(Player player) {
        return player.getBalance() >= 4000;
    }
}
