package knapsack;

import java.io.IOException;

public class mainProgram extends Knapsack {
	
	public mainProgram(Item[] items, int capacity) {
		super(items, capacity);
		
	}

	public static void main(String[] args) throws IOException {
		
		callKnapsack();
	}
}
