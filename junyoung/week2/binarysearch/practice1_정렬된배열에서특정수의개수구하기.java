package junyoung.week2.binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class practice1_정렬된배열에서특정수의개수구하기 {

	static StringTokenizer st;
	static int N, X;
	static int[] num;
	static int firstIdx=-1, lastIdx=-1;
	
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		num = new int[N];
		st = new StringTokenizer(in.readLine());
		for (int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken()); 
		}
		Arrays.sort(num);
		
		firstIdx(X, 0, N-1);
		lastIdx(X, 0, N-1);
		
		System.out.println((firstIdx==-1 && lastIdx==-1) ? -1 : lastIdx-firstIdx+1);
	}
	
	public static void firstIdx(int key, int start, int end) {
		if (start > end) return;
		int mid = (start+end) / 2;
		
		if (num[mid] == key) {
			firstIdx = mid;
			firstIdx(key, start, mid-1);
		}
		else if (num[mid] > key) firstIdx(key, start, mid-1);
		else if (num[mid] < key) firstIdx(key, mid+1, end);
	}
	
	public static void lastIdx(int key, int start, int end) {
		if (start > end) return;
		int mid = (start+end) / 2;
		
		if (num[mid] == key) {
			lastIdx = mid;
			lastIdx(key, mid+1, end);
		}
		else if (num[mid] > key) lastIdx(key, start, mid-1);
		else if (num[mid] < key) lastIdx(key, mid+1, end);
	}
}
