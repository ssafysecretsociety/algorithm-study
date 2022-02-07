package junyoung.week1.mon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class practice5 {
	
	static StringTokenizer st;
	static int N, M;
	static int[] weight;
	static int[] selected = new int[2];
	static int result;
	
	public static void solve(int cnt, int start) {
		if (cnt == 2) {
			if (selected[0] != selected[1]) {
				result += 1;
			}
			return;
		}
		
		for (int i=start; i<N; i++) {
			selected[cnt] = weight[i];
			solve(cnt+1, i+1); 
		}
	} 

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		weight = new int[N];
		
		st = new StringTokenizer(in.readLine());
		for (int i=0; i<N; i++) {
			weight[i] = Integer.parseInt(st.nextToken());
		}
		
		solve(0, 0);
		System.out.println(result);
	}
}
