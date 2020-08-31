package knapsack;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Item {
	
	public String name;
	public int value;
	public int weight;
	
	int minute = 0;
	int calHour = 0;
	int calMinute = 0;
	int startHour = 9;
	int startMinute = 0;
	int n = 1;
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mma");
	
	public LocalTime seminarTime(int startH, int startM) {
		LocalTime Time = LocalTime.of(startH, startM);
		return Time;
	}
	
	public int setHour(int hr) {
		startHour = hr;
		return startHour;
	}
	
	public int setMinute(int min) {
		startMinute = min;
		return startMinute;
	}
	
	public int calHour(int userMinute) {
		LocalTime Time = LocalTime.of(startHour, startMinute);
		int newHour = (userMinute + startMinute) / 60;
		calHour = Time.getHour() + newHour;
		startHour = calHour;
		return calHour;
	}
	
	public int calMinute(int userMinute) {
		calMinute = (userMinute + startMinute) % 60;
		startMinute = calMinute;
		return calMinute;
	}

	public LocalTime BeginTime(int userMinute) {
		LocalTime BeginTime = seminarTime(startHour, startMinute);
		return BeginTime;
	}
	
	public LocalTime EndTime(int userMinute) {
		int endHr = calHour(userMinute);
		int endMin = calMinute(userMinute);
		LocalTime EndTime = seminarTime(endHr, endMin);
		return EndTime;
	}
	
	public String normalTime (int userMinute) {
		LocalTime beginT = BeginTime(userMinute);
		EndTime(userMinute);

		String beginTime = beginT.format(dtf);
		return beginTime;
	}
	
	public Item(String name, int value, int weight) {
		this.name = name;
		this.value = value;
		this.weight = weight;
	}
	
	public String str() {
		return normalTime(weight) + " " + name + " " + weight + "min";
	}

}
