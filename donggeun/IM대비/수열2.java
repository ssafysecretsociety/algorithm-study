package IM대비;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수열2 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] numbers = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // 초기 합 계산
        int sum = 0;
        for (int i = 0; i < K; i++) {
            sum += numbers[i];
        }

        // 한 칸씩 움직이며 그 칸의 값을 더해주고, 첫 값을 빼줌
        int max = sum;
        for (int i = K; i < N; i++) {
            sum += numbers[i];
            sum -= numbers[i - K];
            max = Math.max(max, sum);
        }

        System.out.println(max);

    }
}
