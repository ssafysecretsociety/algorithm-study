package IM대비;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 방배정 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] students = new int[6 + 1][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            students[Y - 1][S]++;
        }

        // 각 학년-성별에 대해 K명 씩 나눈 결과를 cnt에 더해줌
        int cnt = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 2; j++) {
                if (students[i][j] % K == 0) {
                    cnt += students[i][j] / K;
                } else {
                    cnt += students[i][j] / K + 1;
                }
            }
        }

        System.out.println(cnt);


    }
}
