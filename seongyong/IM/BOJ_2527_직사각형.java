// https://www.acmicpc.net/problem/2527

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2527_직사각형 {
    static byte[][] map;

    // out of memory
    static int max = 50001 / 2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            map = new byte[max][max];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                int x1 = Integer.parseInt(st.nextToken());
                int y1 = Integer.parseInt(st.nextToken());
                int x2 = Integer.parseInt(st.nextToken());
                int y2 = Integer.parseInt(st.nextToken());
                input(x1, y1, x2, y2);
            }
            check();
        }

    }

    public static void input(int x1, int y1, int x2, int y2) {
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                map[i][j]++;
            }

        }
    }

    public static void check() {
        int cnt = 0;

        // true면 직선
        boolean flag = true;
        for (int r = 0; r < max; r++) {
            for (int c = 0; c < max; c++) {
                if (map[r][c] == 2) {
                    cnt++;

                    // 직선검사
                    if (flag) {

                        // 한번 직선이 아닌게 밝혀지면 더이상 직선검사 x
                        if (line(r, c))
                            flag = false;
                    }

                }
            }
        }

        if (cnt == 0)
            System.out.println('d');
        else if (cnt == 1)
            System.out.println('c');
        else if (!flag)
            System.out.println('b');
        else
            System.out.println('a');
    }

    public static boolean line(int r, int c) {
        int[] dx = new int[]{1, 0, -1, 0, 1, 1, -1, -1};
        int[] dy = new int[]{0, 1, 0, -1, -1, 1, 1, -1};


        int cnt = 0;
        // 주위 팔방탐색 했을때 2가 2개 보다 더 나오면 직선이 아님
        for (int i = 0; i < 8; i++) {
            int nx = r + dx[i];
            int ny = c + dy[i];

            if (nx < 0 || ny < 0 || nx >= max || ny >= max)
                continue;

            if (map[nx][ny] == 2)
                cnt++;
        }

        if (cnt == 2)
            return true;
        else
            return false;
    }
}
