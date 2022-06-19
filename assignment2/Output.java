/*
 * EE422C Project 2 (Mastermind) submission by
 * Allen Viljoen
 * ajv2648
 * Slip days used: <0>
 * Summer 2022
 */
package assignment2;

public class Output {
	int b;
	int w;
	
	public Output(String code, String input, int numPegs) {
		b = 0;
		w = 0;
		boolean [] checked = new boolean[numPegs];
		for (int i = 0; i < numPegs; i++) {
			if (input.charAt(i) == code.charAt(i)) {
				checked[i] = true;
				b++;
			} else {
				for (int j = 0; j < numPegs; j++) {
					if (input.charAt(i) == code.charAt(j) && !checked[j]) {
						checked[j] = true;
						w++;
					}
				}
			}
		}
	}
	
	public int getBlack() {
		return b;
	}
	
	public int getWhite() {
		return w;
	}
	
	@Override
	public String toString() {
		return "b" + b + "w" + w;
	}
	
	@Override
	public boolean equals(Object object) {
		if (object instanceof Output) {
			Output o = (Output) object;
			return w == o.w && b == o.b;
		} else
			return false;
	}

}
