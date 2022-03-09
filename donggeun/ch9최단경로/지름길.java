package ch9최단경로;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 지름길 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[] dp = new int[D + 1];

        Nodeee[] nodes = new Nodeee[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            nodes[i] = new Nodeee(from, to, weight);
        }

        Arrays.sort(nodes);


        // for 0부터 D까지 탐색
        int index = 0;
        Nodeee nextNode = null;
        for (int i = 0; i <= D; i++) {

            // 도달한적 없는 곳일 때, 이전 칸 + 1로 갱신
            if (dp[i] == 0 && i > 0) {
                dp[i] = dp[i - 1] + 1;
            }

            // 도달한 적 있는 곳일 때, 지금까지의 최대 값 vs 이전 칸 + 1 중 작은 값으로 갱신
            if (dp[i] != 0) {
                dp[i] = Math.min(dp[i], dp[i - 1] + 1);
            }

            // 지름길 모두 방문할 때까지
            while (index < N) {

                // 현재 지름길의 출발점에 도달하지 못했다면 (i != from) break
                nextNode = nodes[index];
                if (nextNode.from != i) {
                    break;
                }

                // 지름길 도착점이 거리를 넘어섰다면, 다음 지름길로 넘어감
                if (nextNode.to > D) {
                    index++;
                    continue;
                }

                // 지름길을 사용한 거리가 dp 테이블을 갱신하지 못한다면 해당 지름길 패스
                int dist = dp[i] + nextNode.weight;
                if (dp[nextNode.to] != 0 && dist >= dp[nextNode.to]) {
                    index++;
                    continue;
                }

                // 살아남은 지름길... 갱신
                index++;
                dp[nextNode.to] = dist;
            }

        }
        System.out.println(dp[D]);
    }

    static class Nodeee implements Comparable<Nodeee> {
        int from;
        int to;
        int weight;

        public Nodeee(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Nodeee o) {
            return this.from - o.from;
        }
    }
}
