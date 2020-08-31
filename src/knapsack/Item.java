package knapsack;

public class Item extends Time {
	
	public String name;
	public int value;
	public int weight;
	
	
	public Item(String name, int value, int weight) {
		this.name = name;
		this.value = value;
		this.weight = weight;
	}
	
	public String str() {
		String BTime = normalTime(weight);
		return BTime + " " + name + " " + weight + "min";
	}

}
