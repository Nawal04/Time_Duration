package src;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class RaceResults {
	
	String tagNumber;
	TimeDuration resultTime;

	static Map <String,Integer> duration = new HashMap<>();

	public RaceResults(String tagNumber, TimeDuration resultTime) {
		this.tagNumber = tagNumber;
		this.resultTime = resultTime;
	}
	
	public void  onNewResult(String tagNumber, TimeDuration resultTime) {
		duration.put(tagNumber, resultTime.seconds);
		
	}
	
	public static void printResult() {
		
		int winner = 0;
		String tag = "";
		
		for (Entry<String, Integer> entry : duration.entrySet()) {
		    
		    if (winner == 0 || winner > entry.getValue()) {
		        winner  = entry.getValue();
		        tag = entry.getKey();
		    }
		}	
		
		System.out.println("The winner: tag=> " + tag  + " Time=>" + winner);
		
	}
	
	public static void main(String[] args) throws Exception {
		TimeDuration seconds0  = new TimeDuration(10);
		RaceResults c1 = new RaceResults("10" , seconds0);
		c1.onNewResult("10" , seconds0);
		
		TimeDuration seconds1  = new TimeDuration(50);
		RaceResults c2 = new RaceResults("50" , seconds1);
		c2.onNewResult("50" , seconds1);
		
		TimeDuration seconds2  = new TimeDuration(30);
		RaceResults c3 = new RaceResults("30" , seconds2);
		c3.onNewResult("30" , seconds2);
		
		printResult();
		
	}	
}
