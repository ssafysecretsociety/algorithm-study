package junyoung.week1.mon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class example2 {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		
		int maxValue = Integer.MIN_VALUE;
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			
			int minValue = Integer.MAX_VALUE;
			for (int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				minValue = Integer.min(minValue, arr[i][j]);
			}
			maxValue = Integer.max(maxValue, minValue);
		}
		System.out.println(maxValue);
	}
}
