package IM대비;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 자리배정 {

    final static int[] dx = {-1, 0, 1, 0};
    final static int[] dy = {0, 1, 0, -1};

    static int R, C;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        int iter = Integer.parseInt(br.readLine());

        if (iter > R * C) {

            // 자리가 부족한 경우에는 바로 0 출력
            System.out.println(0);

        } else {
            int x = R - 1;
            int y = 0;
            int dir = 0;

            // 반복 횟수만큼 반복
            for (int i = 1; i < iter; i++) {

                map[x][y] = i;
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                // 다음에 가야할 좌표가 적절하지 않다면, 다음 좌표값 수정
                if (!isOk(nx, ny)) {
                    dir = (dir + 1) % 4;
                    nx = x + dx[dir];
                    ny = y + dy[dir];
                }

                x = nx;
                y = ny;

            }
            System.out.println((y + 1) + " " + (R - x));

        }
    }

    private static boolean isOk(int x, int y) {
        if (x < 0 || x >= R || y < 0 || y >= C) {
            return false;
        }

        if (map[x][y] != 0) {
            return false;
        }

        return true;
    }

}
