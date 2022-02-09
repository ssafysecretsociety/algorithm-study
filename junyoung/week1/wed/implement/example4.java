package junyoung.week1.wed.implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class example4 {

	static StringTokenizer st;
	static int N, M;
	static int[][] maps;
	static int curX, curY;
	static int direction;
	static int result;
	
	static int[] dx = {-1, 0, 1, 0}; // 0:북, 1:동, 2:남, 3:서
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		curX = Integer.parseInt(st.nextToken());
		curY = Integer.parseInt(st.nextToken());
		direction = Integer.parseInt(st.nextToken());
		
		maps = new int[N][M];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j=0; j<M; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		maps[curX][curY] = -1; // 시작점 방문 표시
		result += 1;
		
		solve();
		System.out.println(result);
	}
	
	public static void solve() {
		while (true) {
			int turnCount = 4;
			
			while (turnCount > 0) {
				turn();
				int nx = curX + dx[direction];
				int ny = curY + dy[direction];
				if (maps[nx][ny] == 0 && maps[nx][ny] != -1) {
					curX = nx;
					curY = ny;
					maps[curX][curY] = -1;
					result += 1;
					break;
				} else {
					turnCount -= 1;
				}
			}
			if (turnCount == 0) {
				// 네 방향 모두 이미 가본 칸이거나 바다로 되어 있는 경우
				curX -= dx[direction];
				curY -= dy[direction];
				if (maps[curX][curY] == 1) break;
			}
		}
	}
	
	public static void turn() {
		direction -= 1;
		if (direction < 0) direction = 3;
	}
}
