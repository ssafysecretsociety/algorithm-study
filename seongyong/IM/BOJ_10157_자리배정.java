//  https://www.acmicpc.net/problem/10157

import java.util.Scanner;

public class BOJ_10157_자리배정 {
    static int C, R;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        C = sc.nextInt();
        R = sc.nextInt();
        int num = sc.nextInt();

        int[][] map = new int[R][C];

        // 시작점
        int r = R - 1;
        int c = 0;
        map[r][c] = 1;

        int idx = 0;
        for (int i = 2; i <= R * C; i++) {
            int nr = r + dx[idx % 4];
            int nc = c + dy[idx % 4];

            if (nr < 0 || nc < 0 || nr >= R || nc >= C || map[nr][nc] != 0) {
                i--;
                idx++;
                continue;
            }
            map[nr][nc] = i;

            r = nr;
            c = nc;
        }
        if (num > C * R)
            System.out.println(0);
        else
            find(map, num);
    }

    public static void find(int[][] map, int n) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == n) {
                    System.out.println((j + 1) + " " + (R - i));
                    System.exit(0);
                }
            }
        }
    }
}
