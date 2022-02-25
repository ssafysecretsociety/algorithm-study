package ch9최단경로;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 전보 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int C = sc.nextInt();

        ArrayList<int[]>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();

            graph[from].add(new int[]{to, weight});
        }

        // 다익스트라 진행
        PriorityQueue<Nodee> pq = new PriorityQueue<>();
        int[] distance = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[C] = 0;
        pq.offer(new Nodee(C, 0));

        while (!pq.isEmpty()) {
            Nodee now = pq.poll();
            if (distance[now.index] < now.distance)
                continue;

            for (int i = 0; i < graph[now.index].size(); i++) {
                int[] next = graph[now.index].get(i);
                int cost = distance[now.index] + next[1];
                if (cost < distance[next[0]]) {
                    distance[next[0]] = cost;
                    pq.offer(new Nodee(next[0], cost));
                }
            }
        }


        // 다익스트라가 진행 된 후, 도달 가능한 곳의 수를 세고
        // 가장 오래걸리는 곳 기준으로 출력
        int max = 0, count = -1;
        for (int i = 1; i <= N; i++) {
            if (distance[i] != Integer.MAX_VALUE) {
                count++;
                max = Math.max(distance[i], max);
            }
        }

        System.out.println(count + " " + max);


    }

    static class Nodee implements Comparable<Nodee> {
        int index;
        int distance;

        public Nodee(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Nodee o) {
            return this.distance - o.distance;
        }
    }


}
