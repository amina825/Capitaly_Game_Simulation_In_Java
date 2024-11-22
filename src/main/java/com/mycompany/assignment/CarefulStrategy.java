package com.mycompany.assignment;

/**
 * Implements a strategy where the player only buys properties or builds houses
 * if they have at least twice the required amount of money.
 */
public class CarefulStrategy implements Strategy {

    /**
     * Determines if the player should buy a property.
     * 
     * @param player the player considering the purchase
     * @param property the property being considered
     * @return true if the player should buy, false otherwise
     */
    @Override
    public boolean shouldBuy(Player player, PropertyField property) {
        return player.getBalance() >= 1000 && player.getBalance() / 2 >= 1000;
    }

    /**
     * Determines if the player should build a house.
     * 
     * @param player the player considering building a house
     * @return true if the player should build, false otherwise
     */
    @Override
    public boolean shouldBuildHouse(Player player) {
        return player.getBalance() >= 4000 && player.getBalance() / 2 >= 4000;
    }
}