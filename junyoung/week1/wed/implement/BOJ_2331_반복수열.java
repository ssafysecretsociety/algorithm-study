package junyoung.week1.wed.implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2331_반복수열 {

	static StringTokenizer st;
	static int A, P;
	static int result;
	static List<Integer> list = new ArrayList<Integer>();
	
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
		A = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		
		list.add(A);
		while (true) {
			int now = list.get(list.size()-1);
			int temp = 0;
			while (now > 0) {
				temp += Math.pow(now % 10, P);
				now /= 10;
			}
			
			if (list.contains(temp)) {
				result = list.indexOf(temp);
				break;
			}
			list.add(temp);
		}
		System.out.println(result);
	}
}
