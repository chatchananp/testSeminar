package knapsack;

import java.util.List;

public class Solution {
	
	// list of items to put in the bag to have the maximal value
	public List<Item> items;
	// maximal value possible
	public int value;
	
	public Solution(List<Item> items, int value) {
		this.items = items;
		this.value = value;
	}
	
	public void display() {
		if (items != null  &&  !items.isEmpty()){
			
//			for (Item item : items) {
			for (int i = 0; i < items.size(); i++) {
				System.out.println(items.get(i).str());
			}
			System.out.println();
		}
	}

}
