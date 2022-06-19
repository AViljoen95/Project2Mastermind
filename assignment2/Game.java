/*
 * EE422C Project 2 (Mastermind) submission by
 * Allen Viljoen
 * ajv2648
 * Slip days used: <0>
 * Summer 2022
 */
package assignment2;

import java.util.Scanner;

public class Game {
	static Scanner kb;
	private String gameCode;
	private int guessesLeft;
	private GameConfiguration config;
	private History gameHistory;
	
	Game(boolean isTesting, GameConfiguration config, SecretCodeGenerator gen, Scanner kb) {
		this.kb = kb;
		guessesLeft = config.guessNumber;
        gameCode = gen.getNewSecretCode();
        this.config = config;
        if (isTesting)
        	System.out.println("\nSecret code: " + gameCode);
		gameHistory = new History(config.guessNumber);
	}
	
	public void runGame() {
		String input;
		Output out;
		while (guessesLeft > 0) {			
			System.out.println("You have " + guessesLeft + " guess(es) left.\nEnter guess: ");
			input = kb.nextLine();
			if (input.equals("HISTORY")) {
				System.out.println("\n" + gameHistory);
				
			} else if (validateGuess(input)) {
				out = new Output(gameCode, input, config.pegNumber);
				System.out.println(input + " -> " + out + "\n");
				gameHistory.add(input, out);
				if (out.getBlack() == config.pegNumber) {
					System.out.println("You win!\n");
					return;
				}
				guessesLeft--;
			} else {
				System.out.println("INVALID_GUESS");				
			}
		}
		System.out.println("You lose! The pattern was " + gameCode);
		
		
	}
	
	
//	Returns true if the guess is valid: correct length and each color is in the palette in game config
	private boolean validateGuess(String input) {
		if (input.length() != config.pegNumber)	// check the easiest thing first
			return false;
		
		boolean inColors;
		char inputCh;
		char paletteColor;
		for (int i = 0; i < input.length(); i++) {	// validate each letter in the input one at a time
			inputCh = input.charAt(i);
			inColors = false;
			for (int j = 0; j < config.colors.length; j++) {	// compare to every color in the palette
				paletteColor = config.colors[j].charAt(0);
				inColors |= (inputCh == paletteColor);	// becomes true if the inputCh matches any color in the palette
			}
			if (!inColors) return false; // returns false if any input color isn't found in the palette
		}
		return true;	// returns true if every input color is found in the palette
	}
	
	@Override
	public boolean equals(Object object) {
		if (object instanceof Game) {
			Game o = (Game) object;
			boolean code = this.gameCode == o.gameCode;
			boolean colors = config.colors.equals(o.config.colors);
			boolean guess = config.guessNumber == o.config.guessNumber;
			boolean pegs = config.pegNumber == o.config.guessNumber;
			return code && colors && guess && pegs;
		} else
			return false;
	}
	

}
