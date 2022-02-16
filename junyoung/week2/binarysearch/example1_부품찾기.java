package junyoung.week2.binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class example1_부품찾기 {

	static StringTokenizer st;
	static int N, M;
	static int[] arr;
	
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		arr = new int[N];

		st = new StringTokenizer(in.readLine());
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		M = Integer.parseInt(in.readLine());
		
		
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(in.readLine());
		for (int i=0; i<M; i++) {
			if (binarySearch(Integer.parseInt(st.nextToken()), 0, N-1)) {
				sb.append("yes").append(" ");
			} else {
				sb.append("no").append(" ");
			}
		}
		System.out.println(sb.toString());
	}
	
	public static boolean binarySearch(int key, int start, int end) {
		while (start <= end) {
			int mid = (start+end) / 2;
			if (arr[mid] == key) return true;
			else if (arr[mid] > key) end=mid-1;
			else if (arr[mid] < key) start=mid+1;
		}
		return false;
	}
}
