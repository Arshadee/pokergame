package io.poker.models;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * This is a static class to store game data in a map statically
 * to simulate a Key Value in mem data store.
 * 
 * To process different game sessions simultaneously
 * 
 * @author arshadmayet
 *
 */
public class GameStore {
	
	public static Map<String, List<Card>> pokerGame = new HashMap<>();
	
	/**
	 * static method used to generate unique game Id
	 * to store deck state
	 * 
	 * @return
	 */
	public static String genGameId() {
		Random random=new Random();
		int rnd = random.nextInt(90) + 10;
	
		Date date = new Date();
		long timeMilli = date.getTime();
		return String.valueOf(timeMilli)+String.valueOf(rnd);
	}

}
