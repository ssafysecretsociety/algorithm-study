package ch5DFS_BFS;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 연구소 {

    static int N, M;
    static int[][] map;
    static ArrayList<int[]> blank;
    static ArrayList<int[]> cases = new ArrayList<>();
    static int[] numbers = new int[3];
    static boolean[][] isVisited;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    // bfs
    public static void bfs(int x, int y, int[][] map) {
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{x, y});
        isVisited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] loc = queue.poll();
            x = loc[0];
            y = loc[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }

                if (isVisited[nx][ny] || map[nx][ny] != 0) {
                    continue;
                }

                // 범위 안에 있고 방문하지 않았고 벽이 아닌경우 감염
                isVisited[nx][ny] = true;
                map[nx][ny] = 2;
                queue.offer(new int[]{nx, ny});
            }
        }
    }

    // 조합
    public static void combination(int cnt, int start) {
        if (cnt == 3) {
            cases.add(Arrays.copyOf(numbers, numbers.length));
            return;
        }

        for (int i = start; i < blank.size(); i++) {
            numbers[cnt] = i;
            combination(cnt + 1, i + 1);
        }
    }


    // 2차원 배열 복사
    public static int[][] arrCopy(int[][] origin) {
        int[][] copy = new int[origin.length][origin.length];
        for (int i = 0; i < origin.length; i++) {
            copy[i] = origin[i].clone();
        }
        return copy;
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        blank = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    blank.add(new int[]{i, j});
                }
            }
        }

        combination(0, 0);

        int max = Integer.MIN_VALUE;
        for (int[] oneCase : cases) {
            // 각각의 케이스에 대하여

            // 1. map 복사
            int[][] testMap = arrCopy(map);

            // 2. 복사한 map에 벽 설치
            for (int i : oneCase) {
                int[] loc = blank.get(i);
                testMap[loc[0]][loc[1]] = 1;
            }

            // 3. bfs 통해 바이러스 전파
            isVisited = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (testMap[i][j] == 2) {
                        bfs(i, j, testMap);
                    }
                }
            }

            // 4. 안전 구역 수 계산 -> 최대값 갱신
            int safe = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (testMap[i][j] == 0) {
                        safe++;
                    }
                }
            }

            max = Math.max(safe, max);


        }
        System.out.println(max);
    }
}
