package ch8다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정수삼각형 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        StringTokenizer st = null;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i + 1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N][N];
        dp[0][0] = map[0][0];

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i + 1; j++) {

                // 왼쪽 끝 수일 경우 오른쪽 위 수와 현재 값을 더해줌
                if (j == 0) {
                    dp[i][j] = map[i][j] + dp[i - 1][j];
                } else if (j == i) {
                    // 오른쪽 끝 수일 경우 왼쪽 위 수와 현재 값을 더해줌
                    dp[i][j] = map[i][j] + dp[i - 1][j - 1];
                } else {
                    // 가운데 수일 경우 왼쪽 위 수와 오른쪽 위 수 중 큰 값과 현재 값을 더해줌
                    dp[i][j] = map[i][j] + Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, dp[N - 1][i]);
        }

        System.out.println(max);


    }
}
