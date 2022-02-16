package ch7이진탐색;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 떡볶이떡만들기 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] ttoek = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ttoek[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 2000000000;


        int mid = (start + end) / 2, sum = 0, max = mid;

        while (start <= end) {
            sum = 0;
            mid = (start + end) / 2;
            for (int i = 0; i < N; i++) {
                if (ttoek[i] - mid < 0) {
                    continue;
                }
                sum += ttoek[i] - mid;
            }

            // 1. 총 합이 M보다 큰거나 같을 경우 일단 저장, 더 큰 수는 없나 탐색
            if (sum >= M) {
                start = mid + 1;
                max = mid;
            } else {
                // 2. 총 합이 M보다 작은 경우 더 작은 범위로 탐색
                end = mid - 1;
            }
        }
        System.out.println(max);
    }
}
