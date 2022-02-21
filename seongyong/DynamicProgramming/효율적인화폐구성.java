import java.util.Arrays;
import java.util.Scanner;

public class 효율적인화폐구성 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = sc.nextInt();
        }
        Arrays.sort(coins);

        int[] dp = new int[M + coins[N-1] + 1];
        for (int i = 0; i < N; i++)
            dp[coins[i]] = 1;

        for (int i = coins[0]; i <= M; i++) {
            for (int c = 0; c < N; c++) {
                int count = dp[i] + 1;
                if(dp[i+coins[c]] == 0)
                    dp[i+coins[c]] = count;
                else
                    dp[i + coins[c]] = Math.min(count, dp[i + coins[c]]);
            }
        }

        if(dp[M] == 0)
            System.out.println(-1);
        else
            System.out.println(dp[M]);
    }
}
