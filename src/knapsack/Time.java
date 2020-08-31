package knapsack;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Time {
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

		String beginTime = beginT.format(dtf); //+ EndTime(userMinute);
		return beginTime;
	}
	
	void LunchTime(int userMinute) {
		LocalTime LunchTime = seminarTime(12, 0);
		System.out.print(LunchTime.format(dtf) + " ");
		setHour(13);
		setMinute(0);
	}
	
	void NETime(int userMinute) {
		LocalTime NETime = seminarTime(startHour, startMinute);
		System.out.print(NETime.format(dtf) + " ");
		setHour(9);
		setMinute(0);
		n++;
	}
}
