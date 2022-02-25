package IM대비;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 딱지놀이 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        for (int i = 0; i < N; i++) {
            int[] playerOne = new int[5];
            int[] playerTwo = new int[5];

            // p1 input
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            for (int j = 0; j < a; j++) {
                playerOne[Integer.parseInt(st.nextToken())]++;
            }

            // p2 input
            st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());
            for (int j = 0; j < b; j++) {
                playerTwo[Integer.parseInt(st.nextToken())]++;
            }

            // 조건에 따라 결과 출력
            if (playerOne[4] != playerTwo[4]) {
                if (playerOne[4] > playerTwo[4]) {
                    System.out.println('A');
                } else {
                    System.out.println('B');
                }
                continue;
            }

            if (playerOne[3] != playerTwo[3]) {
                if (playerOne[3] > playerTwo[3]) {
                    System.out.println('A');
                } else {
                    System.out.println('B');
                }
                continue;
            }

            if (playerOne[2] != playerTwo[2]) {
                if (playerOne[2] > playerTwo[2]) {
                    System.out.println('A');
                } else {
                    System.out.println('B');
                }
                continue;
            }

            if (playerOne[1] != playerTwo[1]) {
                if (playerOne[1] > playerTwo[1]) {
                    System.out.println('A');
                } else {
                    System.out.println('B');
                }
                continue;
            } else {
                System.out.println('D');
            }

        }
    }
}
