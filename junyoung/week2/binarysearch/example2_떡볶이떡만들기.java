package junyoung.week2.binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class example2_떡볶이떡만들기 {

	static StringTokenizer st;
	static int N, M;
	static int[] rice;
	static int maxHeight;
	
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		rice = new int[N];
		st = new StringTokenizer(in.readLine());
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i=0; i<N; i++) {
			rice[i] = Integer.parseInt(st.nextToken());
			min = Math.min(min, rice[i]);
			max = Math.max(max, rice[i]);
		}
		binarySearch(M, min, max);
		System.out.println(maxHeight);
	}

	public static void binarySearch(int key, int start, int end) {
		if (start > end) return;
		int mid = (start+end) / 2;
		
		if (cutRice(mid) == key) {
			maxHeight=mid;
			return;
		}
		else if (cutRice(mid) > key) binarySearch(key, mid+1, end);
		else if (cutRice(mid) < key) binarySearch(key, start, mid-1);
	}
	
	public static int cutRice(int h) {
		int sum = 0;
		for (int i=0; i<N; i++) {
			int diff = rice[i] - h;
			if (diff > 0) sum += diff;
		}
		return sum;
	}
}
