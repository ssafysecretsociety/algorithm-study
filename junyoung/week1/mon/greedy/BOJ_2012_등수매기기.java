package junyoung.week1.mon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2012_등수매기기 {

	static StringTokenizer st;
	static int[] expectScore;
	static long sum;
	
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		expectScore = new int[N+1];
		
		for (int i=1; i<=N; i++) {
			expectScore[i] = Integer.parseInt(in.readLine());
		}
		Arrays.sort(expectScore);
		
		for (int i=1; i<=N; i++) {
			sum += Math.abs(expectScore[i] - i);
		}
		System.out.println(sum);
	}
}