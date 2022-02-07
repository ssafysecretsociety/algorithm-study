package junyoung.week1.mon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class practice2 {

	static StringTokenizer st;
	static int[] num;
	static int result;
	
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String data = in.readLine();
		num = new int[data.length()];
		
		for (int i=0; i<num.length; i++) {
			num[i] = data.charAt(i) - '0';
		}
		
		result = num[0];
		for (int i=1; i<num.length; i++) {
			if (num[i] == 0 || num[i] == 1 || result == 0 || result == 1) {
				result += num[i];
			} else {
				result *= num[i];
			}
		}
		System.out.println(result);
	}
}
