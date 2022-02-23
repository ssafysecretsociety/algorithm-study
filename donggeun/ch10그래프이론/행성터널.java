package ch10그래프이론;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 행성터널 {

    static int[] parents;

    private static int find(int n) {
        if (n == parents[n]) return n;
        return parents[n] = find(parents[n]);
    }

    private static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return false;
        parents[a] = b;
        return true;
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Edge[] edges = new Edge[N * (N - 1) / 2];

        StringTokenizer st = null;
        int[][] map = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 조합으로 탐색하며 거리를 계산해준 간선을 추가해줌
        int index = 0;
        int fx = 0, fy = 0, fz = 0, sx = 0, sy = 0, sz = 0, weight = 0;
        for (int i = 0; i < N - 1; i++) {
            fx = map[i][0];
            fy = map[i][1];
            fz = map[i][2];
            for (int j = i + 1; j < N; j++) {
                sx = map[j][0];
                sy = map[j][1];
                sz = map[j][2];

                weight = Math.min(Math.min(Math.abs(fx - sx), Math.abs(fy - sy)), Math.abs(fz - sz));
                edges[index++] = new Edge(i, j, weight);

            }
        }

        parents = new int[N];
        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }

        Arrays.sort(edges);

        // 크루스칼 알고리즘 진행
        int result = 0, count = 0;
        for (Edge edge : edges) {
            if (union(edge.from, edge.to)) {
                result += edge.weight;
                if (++count == N) break;
            }
        }

        System.out.println(result);


    }

    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }


        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

}
