// https://www.acmicpc.net/problem/2578

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2578_빙고 {
    static int board[][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // input
        board = new int[5][5];
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                check(Integer.parseInt(st.nextToken()));
                int ans = bingo();
                if (ans >= 3) {
                    System.out.println(i * 5 + (j + 1));
                    System.exit(0);
                }
            }
        }
    }

    // 해당하는 수의 빙고 체크
    public static void check(int n) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[i][j] == n) {
                    board[i][j] = 0;
                    break;
                }
            }
        }
    }

    // 빙고 체크
    public static int bingo() {
        int cnt = 0;
        // 행 체크
        for (int i = 0; i < 5; i++) {
            int rowCnt = 0;
            for (int j = 0; j < 5; j++) {
                if (board[i][j] == 0)
                    rowCnt++;
            }
            if (rowCnt == 5)
                cnt++;
        }

        // 열 체크
        for (int i = 0; i < 5; i++) {
            int colCnt = 0;
            for (int j = 0; j < 5; j++) {
                if (board[j][i] == 0)
                    colCnt++;
            }
            if (colCnt == 5)
                cnt++;
        }

        // 좌상우하 대각 체크
        int leftDiagonalCnt = 0;
        for (int i = 0; i < 5; i++) {
            if (board[i][i] == 0)
                leftDiagonalCnt++;
        }
        if (leftDiagonalCnt == 5)
            cnt++;

        // 우상좌하 대각 체크
        int rightDiagonalCnt = 0;
        for (int i = 0; i < 5; i++) {
            if (board[i][4 - i] == 0)
                rightDiagonalCnt++;
        }
        if (rightDiagonalCnt == 5)
            cnt++;
        return cnt;
    }
}
