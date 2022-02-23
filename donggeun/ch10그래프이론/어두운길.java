package ch10그래프이론;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 어두운길 {

    static int[] parents;

    private static int find(int n) {
        if (n == parents[n]) return n;
        return parents[n] = find(parents[n]);
    }

    private static boolean union(int a, int b) {
        if (find(a) == find(b)) return false;
        parents[find(a)] = find(b);
        return true;
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Eddge[] edges = new Eddge[M];
        parents = new int[N];
        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }

        // 입력 받으며 무게의 총합을 계산해줌
        int weightSum = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            weightSum += weight;
            edges[i] = new Eddge(from, to, weight);
        }

        Arrays.sort(edges);

        // 크루스칼 진행
        int result = 0, count = 0;
        for (Eddge edge : edges) {
            if (union(edge.from, edge.to)) {
                result += edge.weight;
                if (++count == N) break;
            }
        }

        // 절약한 비용 출력
        System.out.println(weightSum - result);

    }

    static class Eddge implements Comparable<Eddge> {
        int from;
        int to;
        int weight;

        public Eddge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Eddge o) {
            return this.weight - o.weight;
        }
    }
}
