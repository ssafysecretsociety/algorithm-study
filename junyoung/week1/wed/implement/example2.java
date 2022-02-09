package junyoung.week1.wed.implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class example2 {

	static StringTokenizer st;
	static int N;
	static int cnt;
	
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		
		boolean flag = false;
		for (int i=0; i<=N; i++) {
			for (int j=0; j<60; j++) {
				for (int k=0; k<60; k++) {
					if (i/10 == 3 || i%10 == 3 || j/10 == 3 || j%10 == 3 || k/10 == 3 || k%10 == 3) cnt += 1;
				}
			}
		}
		System.out.println(cnt);
	}
}