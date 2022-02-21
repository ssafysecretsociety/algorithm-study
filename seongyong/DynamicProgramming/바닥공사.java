import java.util.Scanner;

public class 바닥공사 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] dp = new int[1001];

        // 2 * 2 넓이를 채우는 경우의 수는 2
        // 2 * 3 넓이를 채우는 경우의 수는 5

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        dp[4] = 12;

        for (int i = 5; i < N + 1; i++) {
            dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 796796;
        }

        System.out.println(dp[N]);
    }
}
