import java.util.Scanner;

public class 일로만들기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int X = sc.nextInt();
        int[] dp = new int[300001];

        for (int i = 0; i <= X; i++)
            dp[i] = Integer.MAX_VALUE;

        // 시작 지점
        dp[1] = 0;

        for (int i = 1; i <= X; i++) {
            // +1
            dp[i+1] = Math.min(dp[i+1], dp[i] + 1);

            // *2
            dp[i*2] = Math.min(dp[i*2], dp[i] + 1);

            // * 5
            dp[i*5] = Math.min(dp[i*5], dp[i] + 1);
        }

        System.out.println(dp[X]);
    }
}
