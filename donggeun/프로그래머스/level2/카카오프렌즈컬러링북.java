// 2017 카카오코드 예선
// https://programmers.co.kr/learn/courses/30/lessons/1829

package 프로그래머스.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 카카오프렌즈컬러링북 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new 카카오프렌즈컬러링북().solution(6, 4, new int[][]{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}})));
    }

    // return: 몇 칸 칠했는지
    static int bfs(int[][] picture, int x, int y) {

        int m = picture.length;
        int n = picture[0].length;

        int color = picture[x][y]; // 현 위치의 색상 저장

        int count = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        picture[x][y] = 0;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                // 범위 내에 없거나 색이 다르다면 (다른 영역이라면) continue
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || picture[nx][ny] != color) continue;

                // 아닐경우 count++, 그림에서 해당 부분 0으로 리셋
                count++;
                picture[nx][ny] = 0;
                queue.offer(new int[]{nx, ny});
            }
        }

        return count;
    }

    public int[] solution(int m, int n, int[][] picture) {

        int count = 0;
        int max = Integer.MIN_VALUE;

        // 이유는 모르겠는데, 배열 복사를 해야 통과
        int[][] copied = new int[m][n];
        for (int i = 0; i < m; i++) {
            copied[i] = picture[i].clone();
        }

        // 매 칸 탐색하며 0이 아닐 때 bfs 실행
        // 한 번 bfs를 실행할 때마다 영역 count++;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (copied[i][j] != 0) {
                    max = Math.max(bfs(copied, i, j), max);
                    count++;
                }
            }
        }

        return new int[]{count, max};
    }
}

// 1 1 1 0
// 1 2 2 0
// 1 0 0 1
// 0 0 0 1
// 0 0 0 3
// 0 0 0 3