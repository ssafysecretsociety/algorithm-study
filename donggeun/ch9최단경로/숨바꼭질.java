package ch9최단경로;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 숨바꼭질 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        int[] distance = new int[N + 1];
        Arrays.fill(distance, 500000000);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        distance[1] = 0;

        // 다익스트라 진행
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            for (int i = 0; i < graph[now.index].size(); i++) {
                int next = graph[now.index].get(i);
                int cost = now.distance + 1;
                if (cost < distance[next]) {
                    distance[next] = cost;
                    pq.offer(new Node(next, cost));
                }
            }
        }

        // 가장 먼 거리와 같은 거리인 노드의 개수를 계산
        int max = Integer.MIN_VALUE, index = -1, count = 0;
        for (int i = 1; i <= N; i++) {
            if (distance[i] > max) {
                max = distance[i];
                index = i;
                count = 1;
            } else if (distance[i] == max) {
                count++;
            }
        }
        System.out.println(index + " " + max + " " + count);


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
