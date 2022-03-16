// https://www.acmicpc.net/problem/11404

import java.util.Arrays;
import java.util.Scanner;

public class 플로이드 {
    static final int INF = (int) 1e9;
    public static int n, m;
    public static int[][] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        graph = new int[n][n];
        for (int i = 0; i < graph.length; i++) {
            Arrays.fill(graph[i], INF);
        }

        for (int a = 0; a < n; a++) {
            for (int b = 0; b < n; b++) {
                if (a == b) graph[a][b] = 0;
            }
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt()-1;
            int b = sc.nextInt()-1;
            int c = sc.nextInt();

            // 더 거리가 작은 간선이 이미 존재하면 pass
            if (c < graph[a][b]) graph[a][b] = c;
        }

        for (int k = 0; k < n; k++) {
            for (int a = 0; a < n; a++) {
                for (int b = 0; b < n; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        for (int a = 0; a < n; a++) {
            for (int b = 0; b < n; b++) {
                if(graph[a][b] == INF)
                    System.out.print(0 +" ");
                else
                    System.out.print(graph[a][b] +" ");
            }
            System.out.println();
        }
    }
}