// https://www.acmicpc.net/problem/14501

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 퇴사 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        ArrayList<int[]> arrayList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int pay = Integer.parseInt(st.nextToken());
            arrayList.add(new int[]{day, pay});
        }

        int[] dp = new int[N + 1];
        for (int i = 0; i < N; i++) {
            int[] tmp = arrayList.get(i);

            // 비교 가능한 일 수를 넘을 때
            if (tmp[0] + i > N)
                continue;

            // 다음 접근일과 새로운 값 비교
            dp[i + tmp[0]] = Math.max(dp[i + tmp[0]], dp[i] + tmp[1]);

            // 성공적으로 업데이트가 되었다면 뒤에 금액도 업데이트
            if(dp[i + tmp[0]] == dp[i] + tmp[1]){
                for (int j = i + tmp[0] + 1; j < N; j++) {
                    dp[j] = Math.max(dp[j], dp[i+tmp[0]]);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);

    }
}
