// p.118 게임 개발

package ch4구현;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class 게임개발 {

    // 왼쪽 방향으로 돌아주는 메서드
    public static int turnLeft(int direction) {
        if (direction == 0) {
            return 3;
        }
        return --direction;
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int N = sc.nextInt();
        int M = sc.nextInt();

        int x = sc.nextInt();
        int y = sc.nextInt();
        int direction = sc.nextInt();

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        // 해당 칸에 방문했는지를 표시해주는 2차원 배열 정의 + 현재 칸 true
        boolean[][] isVisited = new boolean[N][M];
        isVisited[x][y] = true;

        // 방문한 칸의 수 (현재 칸 포함해 1로 초기화)
        int visited = 1;

        while (true) {
            int turnCount = 0;

            // 총 4번의 기회
            while (turnCount < 4) {
                direction = turnLeft(direction);
                int nx = x + dx[direction];
                int ny = y + dy[direction];

                // 만약 회전 후 옆 칸이 빈칸이라면 이동, 다음 반복으로 넘어감
                if (map[nx][ny] != 1 && !isVisited[nx][ny]) {
                    x = nx;
                    y = ny;
                    isVisited[x][y] = true;
                    visited++;
                    break;
                }
                turnCount++;
            }

            // 4번 회전해도 칸이 없을 때, 뒷 칸이 바다라면 이동 종료
            if (turnCount == 4) {
                int nx = x - dx[direction];
                int ny = y - dy[direction];
                if (map[nx][ny] != 1) {
                    x = nx;
                    y = ny;
                } else {
                    break;
                }
            }
        }

        System.out.println(visited);

    }
}
