package junyoung.week1.mon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class practice4 {

	static StringTokenizer st;
	static int N;
	static int[] coin;
	static int minValue;
	
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		coin = new int[N];
		
		for (int i=0; i<N; i++) {
			coin[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(coin);

		int price=1;
		while (true) {
			
			boolean flag = false;
			
			for (int i=0; i<N; i++) {
				
				int sum = 0;
				for (int j=i; j<N; j++) {
					sum += coin[j];
					if (sum == price) {
						flag = true;
						break;
					}
				}
				if (flag) break;
			}
			
			if (!flag) {
				minValue = price;
				break;
			}
			price += 1;
		}
		System.out.println(minValue);
	}
}
