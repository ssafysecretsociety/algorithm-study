package junyoung.week1.mon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class practice1 {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		
		int[] arr = new int[N];
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		int cnt = 0;
		int result = 0;
		
		for (int i=0; i<N; i++) { // 가장 작은 공포도를 가진 모험가부터 그룹으로 빼낼 수 있다.
			cnt += 1;
			if (arr[i] <= cnt) {
				result += 1;
				cnt = 0;
			}
		}
		System.out.println(result);
	}
}