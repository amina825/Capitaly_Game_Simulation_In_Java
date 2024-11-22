package com.mycompany.assignment;

/**
 * Represents a service field on the game board that charges the player a fee.
 */
public class ServiceField extends Field {    
    private int cost;

    /**
     * Constructs a ServiceField with the specified cost.
     * 
     * @param cost the cost charged to the player
     */
    public ServiceField(int cost) {
        this.cost = cost;
    }

    /**
     * Charges the player a fee when they land on this field.
     * 
     * @param player the player who landed on the field
     * @param game the game instance
     */
    @Override
    public void landOn(Player player, Game game) {
        player.payBank(cost);
    }
}