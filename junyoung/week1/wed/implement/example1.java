package junyoung.week1.wed.implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class example1 {

	static StringTokenizer st;
	static int N;
	static int[][] maps;
	static int x, y;
	
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		
		maps = new int[N+1][N+1];
		x = 1;
		y = 1;

		st = new StringTokenizer(in.readLine());
		while (st.hasMoreTokens()) {
			move(st.nextToken().charAt(0));
		}
		System.out.println(x + " " + y);
	}
	
	public static void move(char dir) {
		if (dir == 'L' && y-1 > 0) {
			y -= 1;
		} else if (dir == 'R' && y+1 <= N) {
			y += 1;
		} else if (dir == 'U' && x-1 > 0) {
			x -= 1;
		} else if (dir == 'D' && x+1 <= N) {
			x += 1;
		}
	}
}