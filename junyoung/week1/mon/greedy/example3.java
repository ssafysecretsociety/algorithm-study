package junyoung.week1.mon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class example3 {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int cnt = 0;
		while (N > 1) {
			if (N % K ==0) {
				N /= K;
				cnt += 1;
				continue;
			}
			N -=1;
			cnt += 1;
		}
		System.out.println(cnt);
	}
}
