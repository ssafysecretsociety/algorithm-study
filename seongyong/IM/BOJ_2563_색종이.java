// https://www.acmicpc.net/problem/2563

import java.util.Scanner;

public class BOJ_2563_색종이 {
	static int[][] map = new int[100][100];
	final static int cm = 10;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			int left = sc.nextInt();
			int down = sc.nextInt();

			// 좌상단 좌표
			int r1 = 100 - (left + cm);
			int c1 = down;

			// 우하단 좌효
			int r2 = 100 - left;
			int c2 = (down + cm); 

			attach(r1, c1, r2, c2);
		}
		System.out.println(calc());
	}

	public static void attach(int r1, int c1, int r2, int c2) {
		for (int i = r1; i < r2; i++) {
			for (int j = c1; j < c2; j++) {
				map[i][j]++;
			}
		}
	}

	public static int calc() {
		int sum = 0;

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] >= 1) {
					sum++;
				}
			}
		}
		return sum;
	}
}
