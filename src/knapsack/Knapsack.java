package knapsack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Knapsack extends readData {

	// items of our problem
	private Item[] items;
	// capacity of the bag
	private int capacity;

	public Knapsack(Item[] items, int capacity) {
		this.items = items;
		this.capacity = capacity;
	}
	
	

	public void display() {
		if (items != null && items.length > 0) {
			System.out.println("Knapsack problem");
			System.out.println("Capacity : " + capacity);
			System.out.println("Items :");

			for (Item item : items) {
				System.out.println("- " + item.str());
			}
		}
	}

	// write the solve algorithm
	public Solution solve() {
		int NB_ITEMS = items.length;
		// use a matrix to store the max value at each nth item
		int[][] matrix = new int[NB_ITEMS + 1][capacity + 1];

		// first line is initialized to 0
		for (int i = 0; i <= capacity; i++)
			matrix[0][i] = 0;

		// iterate on items
		for (int i = 1; i <= NB_ITEMS; i++) {
			// iterate on each capacity
			for (int j = 0; j <= capacity; j++) {
				if (items[i - 1].weight > j) {
					matrix[i][j] = matrix[i - 1][j];
				} else {
					// maximize value at this rank in the matrix
					matrix[i][j] = Math.max(matrix[i - 1][j],
							matrix[i - 1][j - items[i - 1].weight] + items[i - 1].value);
				}

			}
		}

		int res = matrix[NB_ITEMS][capacity];
		int w = capacity;
		List<Item> itemsSolution = new ArrayList<>();
		for (int i = NB_ITEMS; i > 0 && res > 0; i--) {
			if (res != matrix[i - 1][w]) {
				itemsSolution.add(items[i - 1]);
				// remove items value and weight
				res -= items[i - 1].value;
				w -= items[i - 1].weight;
			}
		}

		return new Solution(itemsSolution, matrix[NB_ITEMS][capacity]);
	}

	public static void callKnapsack() throws IOException {

		ArrayList<String> nameList = new ArrayList<>();
		ArrayList<Integer> minList = new ArrayList<>(); // weight

		for (int i = 0; i < seminarNameArray().size(); i++) {
			nameList.add(seminarNameArray().get(i));
			minList.add(seminarMinArray().get(i));
		}

		Random rand = new Random();
		Set<Integer> generated = new LinkedHashSet<Integer>();

		// Prevent repeat
		while (generated.size() < minList.size()) {
			generated.add(rand.nextInt(30));
		}

		ArrayList<Integer> randList = new ArrayList<Integer>(generated); // value

		Integer[] minArray = new Integer[minList.size()];
		minArray = minList.toArray(minArray);

		Integer[] randArray = new Integer[randList.size()];
		randArray = randList.toArray(randArray);

		for (int i = 0; i < minList.size(); i++) {
			String name = nameList.get(i);
			Integer random = randArray[i];
			Integer minute = minArray[i];
			Item[] items = { new Item(name, random, minute) };
			
			Knapsack knapsack1 = new Knapsack(items, 180);
//			knapsack1.display();
			Solution solution1 = knapsack1.solve();
			solution1.display();
			
		}
		
//		for (int i = 0; i < minList.size(); i++) {
//			Knapsack knapsack1 = new Knapsack(items, 180);
////			knapsack1.display();
//			Solution solution1 = knapsack1.solve();
//			solution1.display();
//		}
		
		//test
//		Item[] items = { new Item("Text1", randArray[1], 60),
//				 		 new Item("Text2", randArray[2], 30),
//				 		 new Item("Text3", randArray[3], 45),
//				 		 new Item("Text4", randArray[4], 45),
//				 		 new Item("Text5", randArray[5], 60),
//				 		 new Item("Text6", randArray[6], 60),
//				 		 new Item("Text7", randArray[7], 60),
//						 new Item("Text8", randArray[8], 60)};
////		k1
//		Knapsack knapsack1 = new Knapsack(items, 180);
////		knapsack1.display();
//		Solution solution1 = knapsack1.solve();
//		solution1.display();
////		k2
//		Knapsack knapsack2 = new Knapsack(items, 240);
////		knapsack2.display();
//		Solution solution2 = knapsack2.solve();
//		solution2.display();
	}
}
