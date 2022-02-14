package junyoung.week2.sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class practice4_카드정렬하기 {

	static int N;
	static int result;
	
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		for (int i=0; i<N; i++) {
			pq.add(Integer.parseInt(in.readLine()));
		}
		
		while (true) {
			if (pq.size() == 1) break;
			int a = pq.poll();
			int b = pq.poll();
			pq.add(a+b);
			result += (a+b);
		}
		System.out.println(result);
	}
}
