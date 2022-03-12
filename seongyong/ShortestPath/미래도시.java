import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node implements Comparable<Node> {

    public int index;
    public int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    @Override
    public int compareTo(Node other) {
        return this.distance - other.distance;
    }
}

public class 미래도시 {
    static final int INF = (int) 1e9;
    static int n, m;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static int[] d;


    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        d[start] = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int dist = node.distance; // 현재 노드까지의 비용
            int now = node.index; // 현재 노드
            if (d[now] < dist) continue;
            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).distance;
                if (cost < d[graph.get(now).get(i).index]) {
                    d[graph.get(now).get(i).index] = cost;
                    pq.offer(new Node(graph.get(now).get(i).index, cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        int dest1, dest2;

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(new Node(b, 1));
            graph.get(b).add(new Node(a, 1));
        }

        dest1 = sc.nextInt();
        dest2 = sc.nextInt();

        int result = 0;
        d = new int[100001];
        Arrays.fill(d, INF);
        dijkstra(1);
        result = d[dest2] == INF ? -1 : d[dest2];

        d = new int[100001];
        Arrays.fill(d, INF);
        dijkstra(dest2);
        if (result != INF && d[dest1] != INF)
            result += d[dest1];
        else
            result = -1;

        System.out.println(result);
    }
}

/*
5 7
1 2
1 3
1 4
2 4
3 4
3 5
4 5
4 5
 */
