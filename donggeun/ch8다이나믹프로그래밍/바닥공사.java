package ch8다이나믹프로그래밍;

import java.io.IOException;
import java.util.Scanner;

public class 바닥공사 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] dp = new int[N];

        dp[0] = 1;
        dp[1] = 3;

        // dp[i-2]: 2*2로 채우거나, 1*2 2개로 채우는 경우 존재 (2*1의 경우 밑에서 처리)
        // dp[i-1]: 2*1로 채우는 하나의 경우 존재
        for (int i = 2; i < N; i++) {
            dp[i] = dp[i - 2] * 2 + dp[i - 1];
        }

        System.out.println(dp[N - 1]);

    }
}
