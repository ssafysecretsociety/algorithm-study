package junyoung.week2.sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class practice2_안테나 {
	
	static StringTokenizer st;
	static int N;
	static int[] home;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    N = Integer.parseInt(in.readLine());
	    
	    home = new int[N];
	    int idx = 0;

	    st = new StringTokenizer(in.readLine());
	    while (st.hasMoreTokens()){
	        home[idx++]=Integer.parseInt(st.nextToken());
	    }
	    Arrays.sort(home);
	    System.out.println(home[N/2-1]);
	}
}