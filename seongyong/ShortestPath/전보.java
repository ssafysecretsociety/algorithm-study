import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node2 implements Comparable<Node2> {

    public int index;
    public int distance;

    public Node2(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    @Override
    public int compareTo(Node2 other) {
        return this.distance - other.distance;
    }
}

public class 전보 {
    static final int INF = (int) 1e9;
    static int n, m, start;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static int[] d;


    public static void dijkstra(int start) {
        PriorityQueue<Node2> pq = new PriorityQueue<>();
        pq.offer(new Node2(start, 0));
        d[start] = 0;
        while (!pq.isEmpty()) {
            Node2 node = pq.poll();
            int dist = node.distance; // 현재 노드까지의 비용
            int now = node.index; // 현재 노드
            if (d[now] < dist) continue;
            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).distance;
                if (cost < d[graph.get(now).get(i).index]) {
                    d[graph.get(now).get(i).index] = cost;
                    pq.offer(new Node2(graph.get(now).get(i).index, cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Node(b, c));

        }
        d = new int[n + 1];
        Arrays.fill(d, INF);
        dijkstra(start);

        int cnt = 0;
        int total = 0;
        for (int i = 1; i < d.length; i++) {
            if (d[i] != INF) {
                cnt++;
                total = Math.max(total, d[i]);
            }
        }

        System.out.println(cnt - 1 + " " + total);
    }
}

/*
3 2 1
1 2 4
1 3 2
 */
