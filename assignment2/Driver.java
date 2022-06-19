/*
 * EE422C Project 2 (Mastermind) submission by
 * Allen Viljoen
 * avj2648
 * Slip days used: <0>
 * Summer 2022
 */
package assignment2;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        int numGuesses = 10;
        // colors will always be a single uppercase character
        String [] colors = {"B","R","G","Y","O","P"};
        int numPegs = 4;
        
        GameConfiguration config = new GameConfiguration(numGuesses, colors, numPegs);
        SecretCodeGenerator gen = new SecretCodeGenerator(config);
        start(true, config, gen);
    }

    public static void start(Boolean isTesting, GameConfiguration config, SecretCodeGenerator generator) {
        Scanner kb = new Scanner(System.in);
        String input = "Y";
        Game g;
    	System.out.println("Welcome to Mastermind.");
    	
        do {
	    	System.out.println("Do you want to play a new game? (Y/N):");
	        input = kb.nextLine();
	        if (input.equals("Y")) {
		        g = new Game(isTesting, config, generator, kb);
		        g.runGame();
	        }	        
        } while (input.equals("Y"));
        
    }
}
