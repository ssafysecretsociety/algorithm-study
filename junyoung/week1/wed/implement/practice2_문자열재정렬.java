package junyoung.week1.wed.implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class practice2_문자열재정렬 {

	static StringTokenizer st;
	static ArrayList<Character> ch = new ArrayList<Character>();
	static int sum;
	
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String S = in.readLine();
		
		for (int i=0; i<S.length(); i++) {
			int data = S.charAt(i) - '0';
			if (data >= 'A'-'0' && data <= 'Z'-'0') {
				ch.add((char)(data+'0'));
			}
			else sum += data;
			
//			if (Character.isLetter(S.charAt(i))) {
//				ch.add(S.charAt(i));
//			} else {
//				sum += (S.charAt(i) - '0');
//			}
		}
		Collections.sort(ch);

		// 출력
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<ch.size(); i++) {
			sb.append(ch.get(i));
		}
		if (sum != 0) sb.append(sum);
		System.out.println(sb.toString());
	}
}