// https://www.acmicpc.net/problem/1932

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정수삼각형 {
    static int dy[] = {0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[][] tri = new int[N][N];
        int[][] dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 1 + i; j++) {
                tri[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = tri[i][j];
            }
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < 1 + i; j++) {
                for (int k = 0; k < 2; k++) {

                    int nx = i + 1;
                    int ny = j + dy[k];

                    if (ny > i + 1)
                        continue;

                    dp[nx][ny] = Math.max(dp[nx][ny], dp[i][j] + tri[nx][ny]);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, dp[N - 1][i]);
        }
        System.out.println(max);
    }

}
