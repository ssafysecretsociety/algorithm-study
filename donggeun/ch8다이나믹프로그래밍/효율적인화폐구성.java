package ch8다이나믹프로그래밍;

import java.io.IOException;
import java.util.Scanner;

public class 효율적인화폐구성 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = sc.nextInt();
        }

        int[] dp = new int[M + 1];
        for (int i = 0; i <= M; i++) {
            dp[i] = -1;
        }
        dp[0] = 0;

        // i원을 만들 수 있을지 하나씩 검사
        for (int i = 1; i <= M; i++) {

            // 각 원마다, 각 코인에 대해서 검사 진행
            for (int j = 0; j < N; j++) {

                // 현재 만드려는 i원이 현재 동전보다 작은 경우 continue
                // 혹은 i원에 현재 동전을 뺀 값이 -1 (도달 불가능한) 인 경우 continue
                if (i - coins[j] < 0 || dp[i - coins[j]] == -1) {
                    continue;
                }

                // 첫방문일 때: 현재 동전을 사용
                if (dp[i] == -1) {
                    dp[i] = dp[i - coins[j]] + 1;
                } else {
                    // 첫 방문이 아니라면, 현재 있는 값과, 이번 동전을 사용한 값 중 더 작은걸로 갱신
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        System.out.println(dp[M]);

    }
}
