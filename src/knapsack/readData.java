package knapsack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class readData {
	private static ArrayList<String> textFile() throws IOException {
		ArrayList<String> seminarArray = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(
									"src/textFile/demo.txt"));) {
			String strLine = br.readLine();
			while (strLine != null) {
				seminarArray.add(strLine);
				strLine = br.readLine();
			}
		}

		return seminarArray;
	}
	
	public static ArrayList<String> seminarNameArray() throws IOException {
		
		ArrayList<String> seminarNameArray = new ArrayList<>();

		for (int i = 0; i < textFile().size(); i++) {
			String seminarName = textFile().get(i);
			
			String patternString1 = "(.*) (\\d+)min";

	        Pattern pattern = Pattern.compile(patternString1);
	        Matcher matcher = pattern.matcher(seminarName);

	        while(matcher.find()) {
	        	String n1 = matcher.group(1);
	        	seminarNameArray.add(n1);
	        }
		}
		return seminarNameArray;
		
	}
	
	public static ArrayList<Integer> seminarMinArray() throws IOException {
		
		ArrayList<Integer> seminarMinArray = new ArrayList<>();

		for (int i = 0; i < textFile().size(); i++) {
			String seminarName = textFile().get(i);
			
			String patternString1 = "(.*) (\\d+)min";

	        Pattern pattern = Pattern.compile(patternString1);
	        Matcher matcher = pattern.matcher(seminarName);

	        while(matcher.find()) {
	        	String n2 = matcher.group(2);
	        	int minute = Integer.parseInt(n2);
	        	seminarMinArray.add(minute);
	        }
		}
		return seminarMinArray;
		
	}
	
}
