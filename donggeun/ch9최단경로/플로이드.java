package ch9최단경로;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 플로이드 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] map = new int[N + 1][N + 1];
        StringTokenizer st = null;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            if (map[from][to] != 0) {
                map[from][to] = Math.min(weight, map[from][to]);
            } else {
                map[from][to] = weight;
            }
        }

        long[][] distance = new long[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    distance[i][j] = 0;
                } else if (map[i][j] != 0) {
                    distance[i][j] = map[i][j];
                } else {
                    distance[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (distance[i][j] >= Integer.MAX_VALUE) {
                    sb.append(0).append(" ");
                } else {
                    sb.append(distance[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());


    }
}
