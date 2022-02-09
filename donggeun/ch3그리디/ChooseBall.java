// p.315 볼링공 고르기

package ch3그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ChooseBall {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력 처리
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] balls = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            balls[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(balls);
        int sum = 0;

        // 앞에서 부터 탐색
        for (int i = 0; i < N - 1; i++) {
            int weight = balls[i];

            // 앞 사람의 공과 무게가 다를 때 까지 continue
            for (int j = i; j < N; j++) {
                if (weight == balls[j]) {
                    continue;
                }

                // 무게가 다른 볼링공 등장 -> 남은 볼링공 수만큼 더해줌
                sum += (N - j);
                break;
            }
        }
        System.out.println(sum);
    }
}
