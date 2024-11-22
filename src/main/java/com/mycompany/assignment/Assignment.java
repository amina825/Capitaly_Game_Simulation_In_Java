/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.assignment;

/**
 * The Assignment class is the entry point of the application.
 * It initializes the game, reads the game configuration from a file,
 * starts the game, and prints the name of the second loser if there is one.
 * <p>
 * This class demonstrates the use of the Game class and its methods.
 * </p>
 */
public class Assignment {

    /**
     * The main method is the entry point of the application.
     * It initializes the game, reads the game configuration from a file,
     * starts the game, and prints the name of the second loser if there is one.
     * 
     * @param args the command line arguments
     * @throws Exception if an error occurs while reading the game file or playing the game
     */
    public static void main(String[] args) throws Exception {
        Game game = new Game();
        game.readGameFile("C:\\Users\\DELL\\Desktop\\Assignment\\src\\main\\java\\com\\mycompany\\assignment\\game.txt");
        game.play();
        Player secondLoser = game.getSecondLoser();
        if (secondLoser != null) {
            System.out.println("Second loser: " + secondLoser.getName());
        } else {
            System.out.println("Not enough players lost.");
        }
    }
}