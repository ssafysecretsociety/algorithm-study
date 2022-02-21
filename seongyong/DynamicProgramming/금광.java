import java.util.Scanner;

public class 금광 {
    static int dx[] = {-1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < tc; t++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[][] map = new int[n][m];
            int[][] dp = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    map[i][j] = sc.nextInt();
                    dp[i][j] = map[i][j];
                }
            }

            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < 3; k++) {
                        int nx = j + dx[k];
                        int ny = i + 1;

                        if (nx < 0 || nx >= n)
                            continue;

                        dp[nx][ny] = Math.max(dp[nx][ny], dp[j][i] + map[nx][ny]);
                    }

                }
            }

            int max = 0;
            for (int i = 0; i < n; i++) {
                max = Math.max(max, dp[i][m-1]);
            }
            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }
}

/*
2
3 4
1 3 3 2 2 1 4 1 0 6 4 7
4 4
1 3 1 5 2 2 4 1 5 0 2 3 0 6 1 2
 */
