package IM대비;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 빙고 {
    static boolean[][] isVisited = new boolean[5][5];
    static HashMap<Integer, int[]> hm = new HashMap<>();
    static int bingoCount = 0;

    // 인자로 들어온 row가 빙고인지 검사
    private static void checkRow(int row) {
        for (int i = 0; i < 5; i++) {
            if (!isVisited[row][i]) {
                return;
            }
        }
        bingoCount++;
    }

    // 인자로 들어온 col이 빙고인지 검사
    private static void checkCol(int col) {
        for (int i = 0; i < 5; i++) {
            if (!isVisited[i][col]) {
                return;
            }
        }
        bingoCount++;
    }

    // 대각선 (우상단 - 좌하단) 빙고 검사
    private static void checkDigOne() {
        for (int i = 0; i < 5; i++) {
            if (!isVisited[i][4 - i]) {
                return;
            }
        }
        bingoCount++;
    }

    // 대각선 (좌상단 - 우하단) 빙고 검사
    private static void checkDigTwo() {
        for (int i = 0; i < 5; i++) {
            if (!isVisited[i][i]) {
                return;
            }
        }
        bingoCount++;
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력받은 수를 HashMap에 Key, 좌표를 Value로 해서 저장
        StringTokenizer st = null;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                hm.put(Integer.parseInt(st.nextToken()), new int[]{i, j});
            }
        }


        // 사회자가 부르는 수를 ArrayList에 저장
        ArrayList<Integer> numList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                numList.add(Integer.parseInt(st.nextToken()));
            }
        }

        int count = 0;
        for (int i = 0; i < 25; i++) {

            // 사회자가 수를 부를 때마다...
            // count++

            count++;
            int nextNum = numList.get(i);
            int[] loc = hm.get(nextNum);
            isVisited[loc[0]][loc[1]] = true;

            // 현위치에 대해서 bingo 검사
            // 대각선에 위치해 있다면 대각선에 대해서도 검사
            if (loc[0] + loc[1] == 4) {
                checkDigOne();
            }

            if (loc[0] == loc[1]) {
                checkDigTwo();
            }

            checkRow(loc[0]);
            checkCol(loc[1]);

            if (bingoCount >= 3) {
                break;
            }
        }
        System.out.println(count);


    }
}
