package ch10그래프이론;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 유턴싫어 {

    final static int[] dx = {-1, 0, 1, 0};
    final static int[] dy = {0, 1, 0, -1};
    static int R, C;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                // 길을 만난다면, 모든 방향에 대해서 유턴이 필요 없는지 검사
                if (map[i][j] == '.') {
                    if (!bfs(i, j, 0) || !bfs(i, j, 1) || !bfs(i, j, 2) || !bfs(i, j, 3)) {
                        System.out.println(1);
                        return;
                    }
                }
            }
        }
        System.out.println(0);

    }

    private static boolean bfs(int x, int y, int dir) {
        Queue<int[]> queue = new LinkedList<>();

        // 매개변수 토대로 다음 위치를 큐의 첫 원소로 넣어줌
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        if (nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] == 'X') return true;
        queue.offer(new int[]{nx, ny, dir});


        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];
            int nowDir = now[2];

            // 큐에서 꺼낸 좌표가 출발한 장소라면 return true
            if (nowX == x && nowY == y) {
                return true;
            }

            // 4방탐색을 하되, 반대방향은 탐색 X
            for (int i = 0; i < 4; i++) {
                if (i == (nowDir + 2) % 4) continue;

                nx = nowX + dx[i];
                ny = nowY + dy[i];

                if (nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] == 'X') continue;
                queue.offer(new int[]{nx, ny, i});
            }
        }

        // 만약 어떤 경우도 원점으로 돌아오지 못하고 반복문이 종료되었다면
        // 막다른길이므로 return false
        return false;
    }

}
