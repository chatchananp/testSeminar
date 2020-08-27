package knapsack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
	public static void main(String[] args) throws IOException {
		ArrayList<Integer> min = new ArrayList<>();
		ArrayList<String> seminarArray = new ArrayList<>();
		ArrayList<String> seminarNameArray = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(
									"src/textFile/demo.txt"));) {
			String strLine = br.readLine();
			while (strLine != null) {
				seminarArray.add(strLine);
				strLine = br.readLine();
			}
		}

		for (int i = 0; i < seminarArray.size(); i++) {
			String seminarName = seminarArray.get(i);
			
			String patternString1 = "(.*) (\\d+)min";

	        Pattern pattern = Pattern.compile(patternString1);
	        Matcher matcher = pattern.matcher(seminarName);

	        while(matcher.find()) {
	        	String n1 = matcher.group(1);
	        	String n2 = matcher.group(2);
	        	int minute = Integer.parseInt(n2);
	        	min.add(minute);
	        	seminarNameArray.add(n1);
	        }
	        
		}
		
		Random rand = new Random();
		Set<Integer> generated = new LinkedHashSet<Integer>();
		// Prevent repeat
		while (generated.size() < min.size()) {
		    generated.add(rand.nextInt(30));
		}
		ArrayList<Integer> list = new ArrayList<Integer>(generated);
		
		//assume that min is weight and list is value
		System.out.println(min);
		System.out.println(list);
		System.out.println(seminarNameArray);
	}
}
