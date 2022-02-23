package ch9최단경로;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 화성탐사 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dp = new int[N][N];
            for (int[] arr : dp)
                Arrays.fill(arr, -1);
            dp[0][0] = map[0][0];

            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{0, 0});

            while (!queue.isEmpty()) {
                int[] now = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = now[0] + dx[i];
                    int ny = now[1] + dy[i];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                    int nowCost = dp[now[0]][now[1]] + map[nx][ny];

                    if (dp[nx][ny] != -1 && dp[nx][ny] <= nowCost) continue;
                    
                    dp[nx][ny] = nowCost;
                    queue.offer(new int[]{nx, ny});
                }
            }
            System.out.println(dp[N - 1][N - 1]);
        }
    }
}
