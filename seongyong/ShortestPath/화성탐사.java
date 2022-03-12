import java.util.PriorityQueue;
import java.util.Scanner;

public class 화성탐사 {
    static class Mars implements Comparable<Mars> {
        int x;
        int y;
        int cost;

        public Mars(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Mars o) {
            return this.cost - o.cost;
        }
    }

    static final int INF = (int) 1e9;
    static int N, graph[][], dist[][];
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();

            graph = new int[N][N];
            dist = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    graph[i][j] = sc.nextInt();
                    dist[i][j] = INF;
                }
            }

            dijkstra(0, 0);
            System.out.println(dist[N - 1][N - 1]);

        }
    }

    public static void dijkstra(int x, int y) {
        PriorityQueue<Mars> pq = new PriorityQueue<>();

        dist[x][y] = graph[x][y];
        pq.offer(new Mars(x, y, dist[x][y]));

        while (!pq.isEmpty()) {
            Mars node = pq.poll();
            int cost = node.cost; // 현재 노드까지의 비용
            int nx = node.x;
            int ny = node.y;

            for (int i = 0; i < 4; i++) {
                int xx = nx + dx[i];
                int yy = ny + dy[i];

                if (xx < 0 || yy < 0 || xx >= N || yy >= N)
                    continue;

                if (cost + graph[xx][yy] < dist[xx][yy]) {
                    dist[xx][yy] = cost + graph[xx][yy];
                    pq.add(new Mars(xx, yy, dist[xx][yy]));
                }
            }

        }
    }

}
