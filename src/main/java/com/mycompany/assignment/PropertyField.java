package com.mycompany.assignment;

/**
 * Represents a property field on the game board.
 * Players can buy the property, pay rent, or build a house on it.
 */
public class PropertyField extends Field {
    private Player owner = null;
    private boolean hasHouse = false;

    public PropertyField() {}

    /**
     * Defines the action to be taken when a player lands on the property field.
     * 
     * @param player the player who landed on the field
     * @param game the game instance
     */
    @Override
    public void landOn(Player player, Game game) {
        if (owner == null) {
            if (player.getStrategy().shouldBuy(player, this)) {
                player.buyProperty(this);
            }
        } else if (owner != player) {
            player.payRent(owner, hasHouse ? 2000 : 500);
        } else if (!hasHouse && player.getStrategy().shouldBuildHouse(player)) {
            player.buildHouse(this);
        }
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    /**
     * Checks if the property has a house.
     * 
     * @return true if the property has a house, false otherwise
     */
    public boolean hasHouse() {
        return hasHouse;
    }
    public void setHouse(boolean hasHouse) {
        this.hasHouse = hasHouse;
    }
}
