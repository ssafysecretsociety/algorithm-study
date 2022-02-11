// https://www.acmicpc.net/problem/14502

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 연구소 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static int N, M, numbers[];
    static ArrayList<int[]> possible = new ArrayList<>();
    static ArrayList<int[]> combinations = new ArrayList<>();
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0)
                    possible.add(new int[]{i, j});
            }
        }

        // 가능한 모든 벽들의 조합
        numbers = new int[3];
        comb(0, 0);

        int result = 0;
        int[][] origin = copy(map);

        for (int i = 0; i < combinations.size(); i++) {
            int[] a = possible.get(combinations.get(i)[0]);
            int[] b = possible.get(combinations.get(i)[1]);
            int[] c = possible.get(combinations.get(i)[2]);

            map[a[0]][a[1]] = 1;
            map[b[0]][b[1]] = 1;
            map[c[0]][c[1]] = 1;
            for (int j = 0; j < map.length; j++) {
                for (int k = 0; k < map[j].length; k++) {
                    if (map[j][k] == 2) {
                        bfs(j, k);

                    }
                }
            }
            result = Math.max(result, countSafe());
            map = copy(origin);
        }
        System.out.println(result);
    }

    public static void bfs(int r, int c) {
        queue.offer(new int[]{r, c});

        while (!queue.isEmpty()) {
            int[] q = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = q[0] + dx[i];
                int ny = q[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (map[nx][ny] == 1) continue;
                if (map[nx][ny] == 0) {
                    map[nx][ny] = 3;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
    }

    public static void comb(int cnt, int start) {
        if (cnt == 3) {
            int[] tmp = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++)
                tmp[i] = numbers[i];

            combinations.add(tmp);
            return;
        }

        for (int i = start; i < possible.size(); i++) {
            numbers[cnt] = i;
            comb(cnt + 1, i + 1);
        }
    }

    public static int[][] copy(int[][] arr) {
        int[][] tmp = new int[arr.length][arr[0].length];

        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < tmp[0].length; j++) {
                tmp[i][j] = arr[i][j];
            }
        }
        return tmp;
    }

    public static int countSafe() {
        int safe = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0)
                    safe++;
            }
        }
        return safe;
    }

    public static void print() {
        System.out.println("Dd");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
