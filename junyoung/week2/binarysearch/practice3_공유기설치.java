package junyoung.week2.binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class practice3_공유기설치 {

	static StringTokenizer st;
	static int N, C;
	static int[] home;
	static int maxDist;
	
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		home = new int[N];
		for (int i=0; i<N; i++) {
			home[i] = Integer.parseInt(in.readLine());
		}
		Arrays.sort(home);
	
		// minValue = home[1]-home[0]으로 초기화하면 80%에서 WA 받음.
		binarySearch(C, 1, home[N-1]-home[0]);
		System.out.println(maxDist);
	}
	
	public static void binarySearch(int key, int start, int end) {
		if (start > end) return;
		int mid = (start+end) / 2;
		
		// 많은 건 문제가 안된다. 그 중에서 C개만 고르면 되기 때문에.
		if (cntRouter(mid) >= key) {
			maxDist = mid;
			binarySearch(key, mid+1, end);
		}
		else if (cntRouter(mid) < key) binarySearch(key, start, mid-1);
	}
	
	public static int cntRouter(int adjDist) {
		int cnt = 1;
		int position = home[0];
		
		for (int i=1; i<N; i++) {
			if (home[i] - position >= adjDist) {
				cnt += 1;
				position = home[i];
			}
		}
		return cnt;
	}
}
