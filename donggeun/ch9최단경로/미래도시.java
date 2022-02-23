package ch9최단경로;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 미래도시 {

    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            map[a][b] = 1;
            map[b][a] = 1;
        }

        int X = sc.nextInt();
        int K = sc.nextInt();

        int first = dijkstra(1, K);
        int second = dijkstra(K, X);
        if (first == Integer.MAX_VALUE || second == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(first + second);
        }


    }

    private static int dijkstra(int start, int end) {

        int[] distance = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Node> hq = new PriorityQueue<>();
        hq.offer(new Node(start, 0));
        distance[start] = 0;
        while (!hq.isEmpty()) {
            Node now = hq.poll();
            if (now.distance > distance[now.index])
                continue;
            for (int i = 1; i <= N; i++) {
                if (map[now.index][i] == 1) {
                    int cost = now.distance + 1;
                    if (cost < distance[i]) {
                        distance[i] = now.distance + 1;
                        hq.offer(new Node(i, distance[i]));
                    }
                }
            }
        }

        return distance[end];

    }

    static class Node implements Comparable<Node> {
        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }


}
