package junyoung.week2.binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class practice2_고정점찾기 {

	static StringTokenizer st;
	static int N;
	static int[] num;
	static int resultIdx=-1;
	
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		
		num = new int[N];
		st = new StringTokenizer(in.readLine());
		for (int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		
		binarySearch(0, N-1);
		System.out.println(resultIdx);
	}
	
	public static void binarySearch(int start, int end) {
		if (start > end) return;
		int mid = (start+end) / 2;
		
		if (num[mid] == mid) {
			resultIdx = mid;
			return;
		}
		else if (num[mid] < mid) binarySearch(mid+1, end);
		else if (num[mid] > mid) binarySearch(start, mid-1);
	}
}
