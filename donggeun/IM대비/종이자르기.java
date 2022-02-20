package IM대비;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 종이자르기 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        // 짤린 곳을 저장할 배열
        boolean[] verticalCut = new boolean[width];
        boolean[] horizonCut = new boolean[height];

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int mode = Integer.parseInt(st.nextToken());
            int index = Integer.parseInt(st.nextToken());

            // 선택된 곳 짜르기
            if (mode == 0) {
                horizonCut[index - 1] = true;
            } else {
                verticalCut[index - 1] = true;
            }
        }

        System.out.println(Arrays.toString(horizonCut));
        System.out.println(Arrays.toString(verticalCut));

        // 길이의 최대값 구하기
        int maxWidth = 0;
        int count = 0;
        for (int i = 0; i < width; i++) {
            count++;
            // 짤렸다면, 최대값 갱신
            if (verticalCut[i]) {
                maxWidth = Math.max(count, maxWidth);
                count = 0;
            }
        }
        maxWidth = Math.max(count, maxWidth);

        // 높이의 최대값 구하기
        int maxHeight = 0;
        count = 0;
        for (int i = 0; i < height; i++) {
            count++;
            // 짤렸다면, 최대값 갱신
            if (horizonCut[i]) {
                maxHeight = Math.max(count, maxHeight);
                count = 0;
            }
        }
        maxHeight = Math.max(count, maxHeight);

        System.out.println(maxWidth * maxHeight);
    }
}
