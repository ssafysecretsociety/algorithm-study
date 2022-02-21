import java.util.Scanner;

public class 개미전사 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        int[] dp = new int[101];
        dp[0] = nums[0];
        dp[1] = nums[1];

        for (int i = 2; i < N; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }

        System.out.println(dp[N-1]);
    }
}
