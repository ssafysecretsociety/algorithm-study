package junyoung.week1.mon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//BOJ 1439
public class practice3 {

	static StringTokenizer st;
	static int[] count = new int[2];
	static int prev, now;
	
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String input = in.readLine();
		prev = input.charAt(0) - '0';
		
		for (int i=1; i<input.length(); i++) {
			now = input.charAt(i) - '0';
			if (prev != now) {
				count[prev] += 1;
				prev = now; 
			}
		}
		count[prev] += 1;
		
		System.out.println(Integer.min(count[0], count[1]));
	}
}