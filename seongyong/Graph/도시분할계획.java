// https://www.acmicpc.net/problem/1647

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 도시분할계획 {
    static class Edge implements Comparable<Edge> {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            super();
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }

    }
    static int N, M;
    static int[] parents;
    static Edge[] edgeList;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edgeList = new Edge[M];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edgeList[i] = new Edge(from, to, weight);

        }
        Arrays.sort(edgeList);
        parents = new int[N+1];
        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }

        int cnt = 0;

        int[] result = new int[N-1];
        for (Edge edge : edgeList) {
            if (union(edge.from, edge.to)) {
                result[cnt] += edge.weight;
                if (++cnt == N - 1)
                    break;
            }
        }
        Arrays.sort(result);

        int ans = 0;
        for (int i = 0; i < result.length-1; i++) {
            ans += result[i];
        }

        System.out.println(ans);
    }

    public static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);

        if (aRoot == bRoot)
            return false;

        if (aRoot < bRoot)
            parents[bRoot] = aRoot;
        else
            parents[aRoot] = bRoot;

        return true;
    }

    public static int findSet(int a) {
        if (a == parents[a])
            return a;
        return parents[a] = findSet(parents[a]);

    }
}
