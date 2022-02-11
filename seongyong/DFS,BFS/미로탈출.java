import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 미로탈출 {
    static int[][] map;
    static int N, M;
    static Queue<int[]> queue = new LinkedList<>();


    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            char[] c = sc.nextLine().toCharArray();
            for (int j = 0; j < M; j++)
                map[i][j] = c[j] - '0';
        }

        bfs(new int[]{0, 0});
        System.out.println(map[N - 1][M - 1]);
    }

    public static void bfs(int[] start) {
        // 큐 삽입
        queue.offer(new int[]{start[0], start[1]});

        while (!queue.isEmpty()) {
            int[] q = queue.poll();
//            System.out.println(queue.size());
            for (int i = 0; i < 4; i++) {
                int nx = q[0] + dx[i];
                int ny = q[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (map[nx][ny] == 0) continue;
                else if (map[nx][ny] == 1) {
                    queue.offer(new int[]{nx, ny});
                    map[nx][ny] = map[q[0]][q[1]] + 1;
                }
            }
        }
    }
}
