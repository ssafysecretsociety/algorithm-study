package IM대비;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이2 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[1001][1001];

        StringTokenizer st = null;
        int number = 0;
        for (int i = 0; i < N; i++) {
            ++number;
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int width = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            // n번째 색종이에 대해 map을 n으로 채워줌
            for (int j = x; j < x + width; j++) {
                for (int k = y; k < y + height; k++) {
                    map[j][k] = number;
                }
            }
        }

        // count 배열에 색종이별로 구분해 더해줌
        int[] count = new int[N + 1];
        for (int i = 0; i < 1001; i++) {
            for (int j = 0; j < 1001; j++) {
                count[map[i][j]]++;
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.println(count[i]);
        }

    }
}
