package ch8다이나믹프로그래밍;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class 금광 {

    final static int[] dx = {-1, 0, 1};

    static int N, M;
    static int[][] map, dp;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {

            N = sc.nextInt();
            M = sc.nextInt();

            map = new int[N][M];
            dp = new int[N][M];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    map[i][j] = sc.nextInt();

                    // 입력을 받을 때 첫 번째 열이라면 dp table에도 같이 초기화
                    if (j == 0) {
                        dp[i][j] = map[i][j];
                    }
                }
            }

            // 0열의 모든 행에 대해서 mine 출발
            for (int i = 0; i < N; i++) {
                mine(i, 0);
            }

            // 마지막 열의 숫자들 중에서 최대값을 계산
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                max = Math.max(max, dp[i][M - 1]);
            }

            System.out.println(max);

        }

    }

    private static void mine(int x, int y) {

        int score = dp[x][y];

        for (int i = 0; i < 3; i++) {
            int nx = x + dx[i];
            int ny = y + 1;
            if (nx < 0 || nx >= N || ny >= M) {
                continue;
            }

            // dp table 기준 다음 방문 장소에 현재 등록된 값과
            // 현재 방문장소 값 + 다음 방문 장소의 값 중 더 높은 것으로 dp table 갱신
            dp[nx][ny] = Math.max(dp[nx][ny], score + map[nx][ny]);
            mine(nx, ny);
        }

    }
}
