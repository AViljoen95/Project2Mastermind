/*
 * EE422C Project 2 (Mastermind) submission by
 * Allen Viljoen
 * ajv2648
 * Slip days used: <0>
 * Summer 2022
 */
package assignment2;

import java.util.*;

public class History {
	private ArrayList<String> inputs;
	private ArrayList<Output> outputs;
	
	History(int numGuesses) {
		inputs = new ArrayList<String>(numGuesses);
		outputs = new ArrayList<Output>(numGuesses);
	}
	
	public boolean add(String in, Output out) {
		return inputs.add(in) && outputs.add(out);
	}
	
	@Override
	public String toString() {
		if (inputs.size() == 0)
			return "";
		
		StringBuilder hist = new StringBuilder();
		for (int i = 0; i < inputs.size(); i++) {
			hist.append(inputs.get(i) + " -> " + outputs.get(i) + "\n");
		}
		return hist.toString();
	}
}
