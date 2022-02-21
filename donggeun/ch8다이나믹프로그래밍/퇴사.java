package ch8다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // N번째 날 상담을 마칠 경우를 대비해 N+1로 선언
        int[] time = new int[N + 1];
        int[] price = new int[N + 1];
        int[] dp = new int[N + 1];

        StringTokenizer st = null;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            price[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i <= N; i++) {

            // 지금까지 번 돈을 누적해서 더해줌
            max = Math.max(dp[i], max);

            // i번째 날 상담을 진행할 수 있을 때
            if (i + time[i] <= N) {
                // i+time[i]번째 날의 상담 금액은
                // 기존 dp table에서의 값 vs 지금까지 번 돈 + 현재 상담비 중 큰 값이 된다.
                dp[i + time[i]] = Math.max(dp[i + time[i]], max + price[i]);
            }
        }
        System.out.println(dp[N]);


    }
}
