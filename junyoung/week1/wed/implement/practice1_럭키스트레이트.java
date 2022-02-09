package junyoung.week1.wed.implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ 18406
public class practice1_럭키스트레이트 {

	static StringTokenizer st;
	static String input;
	static int idx;
	static int num1, num2;
	
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		input = in.readLine();
		idx = input.length() / 2;
		
		for (int i=0; i<input.length(); i++) {
			int num = input.charAt(i) - '0'; 
			if (i < idx) num1 += num;
			else num2 += num;
		}
		System.out.println((num1 == num2) ? "LUCKY" : "READY");
	}
}