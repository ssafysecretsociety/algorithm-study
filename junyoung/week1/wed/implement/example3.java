package junyoung.week1.wed.implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class example3 {

	static StringTokenizer st;
	static int posX, posY;
	static int result;
	
	static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
	static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
	
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String pos = in.readLine();
		
		posX = pos.charAt(1) - '0';
		posY = pos.charAt(0) - 'a' + 1;
		solve(posX, posY);
		
		System.out.println(result);
	}
	
	public static void solve(int x, int y) {
		for (int i=0; i<8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 1 && nx <= 8 && ny >= 1 && ny <= 8) result += 1;
		}
	}
}