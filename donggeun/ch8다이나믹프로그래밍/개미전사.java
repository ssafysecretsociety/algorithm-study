package ch8다이나믹프로그래밍;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class 개미전사 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] supply = new int[N];

        for (int i = 0; i < N; i++) {
            supply[i] = sc.nextInt();
        }

        // dp table의 앞 두개를 초기화
        int[] dp = new int[N];
        dp[0] = supply[0];
        dp[1] = supply[1];

        // 선택: 2칸 전 것과 현재 창고의 양의 합 vs 이전 창고의 양
        for (int i = 2; i < N; i++) {
            dp[i] = Math.max(dp[i - 2] + supply[i], dp[i - 1]);
        }

        System.out.println(Arrays.toString(dp));


    }
}
