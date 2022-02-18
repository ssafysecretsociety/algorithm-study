package ch7이진탐색;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 굴다리 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] loc = new int[M];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            loc[i] = Integer.parseInt(st.nextToken());
        }

        int start = 1;
        int end = N;

        int height = -1;

        while (start <= end) {
            int mid = (start + end) / 2;

            // left 초기값: 첫 가로등 위치 - 밝기
            int left = loc[0] - mid;

            // 왼쪽 끝이 0보다 크다면 높이를 높여서 탐색
            if (left > 0) {
                start = mid + 1;
                continue;
            }

            int right = loc[0] + mid;

            // 나머지 가로등들에 대해 반복
            for (int i = 1; i < M; i++) {
                int nowLoc = loc[i];

                int nowLeft = nowLoc - mid;

                // 이전 가로등의 오른쪽 값이 현재 가로등 왼쪽 값과 겹치지 않는다면, 높이를 높여서 탐색
                if (nowLeft > right) {
                    start = mid + 1;
                    continue;
                }

                // 아닐경우 오른쪽 값을 현재 가로등 기준 초기화
                right = nowLoc + mid;
            }

            // 탐색을 마친 후 오른쪽 값이 끝까지 닿지 않는다면 높이를 높여서 탐색
            if (right < N) {
                start = mid + 1;
                continue;
            }

            // 모두 채웠을 경우 결과값으로 저장, 높이를 낮춰서 다시 탐색
            height = mid;
            end = mid - 1;
        }

        System.out.println(height);

    }
}
