package ch8다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 병사배치하기 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] soldiers = new int[N + 1];
        int[] dp = new int[N + 1];


        for (int i = 1; i <= N; i++) {
            soldiers[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 1; i <= N; i++) {
            // 현재 병사의 전투력
            int power = soldiers[i];

            // 현재 병사의 전투력이 들어가야 하는 위치 찾기
            // dp table은 항상 내림차순 정렬이 되어있다.
            int index = getIndex(dp, power);
            dp[index] = power;
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (dp[i] == 0) {
                answer = N - i + 1;
                break;
            }
        }

        System.out.println(answer);


    }

    // 이진탐색으로 바꿔야함
    // 만약 배열이...
    // 0, 15, 11, 5
    // 다음 수가 7이라면? 2 return
    private static int getIndex(int[] arr, int key) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= key) {
                return i;
            }
        }
        return -1;
    }
}
