package ch10그래프이론;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 도시분할계획 {

    static int[] parents;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        Edge[] edges = new Edge[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(from, to, weight);
        }

        Arrays.sort(edges);

        int count = 0;
        int result = 0;
        int last = 0;

        // 크루스칼 알고리즘을 진행하며 마지막 간선의 길이를 갱신
        for (Edge edge : edges) {
            if (union(edge.from, edge.to)) {
                result += edge.weight;
                last = edge.weight;
                if (++count == N) break;
            }
        }

        // 마지막 간선을 제거해 도시 분리
        System.out.println(result - last);

    }

    private static int find(int n) {
        if (n == parents[n]) {
            return n;
        }

        // 경로 압축하지 않으면 시간초과!
        return parents[n] = find(parents[n]);
    }

    private static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) {
            return false;
        }
        parents[find(a)] = find(b);
        return true;
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
