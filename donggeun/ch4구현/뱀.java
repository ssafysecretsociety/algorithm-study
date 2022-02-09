// p.327 뱀
// bj 3190
// https://www.acmicpc.net/problem/3190

package ch4구현;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 뱀 {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int[][] map = new int[N + 1][N + 1];

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
        }

        int L = Integer.parseInt(br.readLine());
        int[] times = new int[L + 1];
        char[] directions = new char[L];

        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());
            directions[i] = st.nextToken().charAt(0);
        }
        times[L] = 10001;

        boolean[][] snakeMap = new boolean[N + 1][N + 1];
        Queue<int[]> snakeMove = new ArrayDeque<>();
        int curX = 1, curY = 1, tailX = 1, tailY = 1;
        int direction = 1; // right
        snakeMap[curX][curY] = true;
        snakeMove.add(new int[]{curX, curY});

        int surviveTime = 0;
        int nextTime = times[0];

        outer:
        for (int i = 0; i < L + 1; i++) {
            for (int j = 0; j < nextTime; j++) {
                // 한 칸씩 이동
                surviveTime++;

                int nx = curX + dx[direction];
                int ny = curY + dy[direction];

                if (nx < 1 || nx > N || ny < 1 || ny > N) {
                    break outer;
                }

                if (snakeMap[nx][ny]) {
                    break outer;
                }

                curX = nx;
                curY = ny;
                snakeMove.add(new int[]{curX, curY});
                snakeMap[curX][curY] = true;


                if (map[curX][curY] == 1) {
                    map[curX][curY] = 0;
                } else {
                    // 사과가 없다면
                    snakeMap[tailX][tailY] = false;

                    snakeMove.poll();
                    int[] nextTail = snakeMove.peek();
                    tailX = nextTail[0];
                    tailY = nextTail[1];
                    snakeMap[tailX][tailY] = true;
                }
            }
            nextTime = times[i + 1] - times[i];

            if (directions[i] == 'L') {
                direction = turnLeft(direction);
            } else {
                direction = turnRight(direction);
            }
        }

        System.out.println(surviveTime);


    }

    public static int turnLeft(int direction) {
        if (direction == 0) {
            return 3;
        }
        return --direction;
    }

    public static int turnRight(int direction) {
        if (direction == 3) {
            return 0;
        }
        return ++direction;
    }
}
