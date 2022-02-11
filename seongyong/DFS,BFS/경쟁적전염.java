// https://www.acmicpc.net/problem/18405

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 경쟁적전염 {
    static int N, K, S, X, Y;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static Queue<int[]> queue = new LinkedList<>();
    static ArrayList<int[]> virus = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp != 0) {
                    virus.add(new int[]{tmp, i, j});
                    map[i][j] = tmp;
                }
                map[i][j] = tmp;
            }
        }
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        Collections.sort(virus, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        bfs();
        if (map[X - 1][Y - 1] != 0)
            System.out.println(map[X - 1][Y - 1]);
        else
            System.out.println(0);
    }

    static void bfs() {
        for (int i = 0; i < virus.size(); i++)
            queue.offer(virus.get(i));


        int second = 0;
        while (!queue.isEmpty()) {
            if (second == S)
                break;

            int[] q = queue.poll();

            // 1->2->3 다 돌고 다시 1로 왔을때 초 +1
            if (!queue.isEmpty() && q[0] > queue.peek()[0])
                second++;
            for (int i = 0; i < 4; i++) {
                int nx = q[1] + dx[i];
                int ny = q[2] + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                if (map[nx][ny] == 0) {
                    map[nx][ny] = q[0];
                    queue.offer(new int[]{q[0], nx, ny});
                }

            }
        }
    }
}
