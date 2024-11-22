package com.mycompany.assignment;

/**
 * Implements a strategy where the player alternates between buying and not buying properties.
 */
public class TacticalStrategy implements Strategy {
    private boolean skipNext = false;

    /**
     * Determines if the player should buy a property.
     * Alternates between buying and not buying.
     * 
     * @param player the player considering the purchase
     * @param property the property being considered
     * @return true if the player should buy, false otherwise
     */
    @Override
    public boolean shouldBuy(Player player, PropertyField property) {
        if (skipNext) {
            skipNext = false;
            return false;
        }
        skipNext = true;
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
