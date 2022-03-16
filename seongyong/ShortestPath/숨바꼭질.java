import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Barn implements Comparable<Barn> {

    public int index;
    public int distance;

    public Barn(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    @Override
    public int compareTo(Barn other) {
        return this.distance - other.distance;
    }
}

public class 숨바꼭질 {
    static final int INF = (int) 1e9;
    static int n, m;
    static ArrayList<ArrayList<Barn>> graph = new ArrayList<>();
    static int[] d;


    public static void dijkstra(int start) {
        PriorityQueue<Barn> pq = new PriorityQueue<>();
        pq.offer(new Barn(start, 0));
        d[start] = 0;
        while (!pq.isEmpty()) {
            Barn node = pq.poll();
            int dist = node.distance; // 현재 노드까지의 비용
            int now = node.index; // 현재 노드
            if (d[now] < dist) continue;
            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).distance;
                if (cost < d[graph.get(now).get(i).index]) {
                    d[graph.get(now).get(i).index] = cost;
                    pq.offer(new Barn(graph.get(now).get(i).index, cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Barn>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(new Barn(b, 1));
            graph.get(b).add(new Barn(a, 1));
        }

        d = new int[n + 1];
        Arrays.fill(d, INF);
        dijkstra(1);

        int max = 0;
        int idx = 0;
        for (int i = 1; i <= n; i++) {
            if (d[i] > max) {
                max = d[i];
                idx = i;
            }
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (max == d[i])
                result++;
        }

        System.out.println(idx + " " + max + " " + result);
    }
}

/*
6 7
3 6
4 3
3 2
1 3
1 2
2 4
5 2
 */
