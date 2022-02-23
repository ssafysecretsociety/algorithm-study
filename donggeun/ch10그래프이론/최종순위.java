package ch10그래프이론;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 최종순위 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            int N = Integer.parseInt(br.readLine());
            int[] degree = new int[N + 1];
            int[] rank = new int[N];
            ArrayList<Integer>[] graph = new ArrayList[N + 1];

            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int team = Integer.parseInt(st.nextToken());
                degree[team] = i;
                rank[i] = team;
                for (int j = 0; j < i; j++) {
                    graph[rank[j]].add(team);
                }
            }

            int M = Integer.parseInt(br.readLine());
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                int index = -1;
                for (int j = 0; j < graph[a].size(); j++) {
                    if (graph[a].get(j) == b) {
                        index = j;
                        break;
                    }
                }

                // 바뀐 순서에 대한 처리
                // 그래프 a안에 b가 없는 경우 (즉 그래프 b안에 a가 있음)
                // a가 순위가 더 높았던 경우의 처리
                if (index == -1) {
                    degree[b]++;
                    degree[a]--;
                    graph[b].remove((Integer) a);
                    graph[a].add(b);
                } else {
                    // 위와 반대!!
                    degree[a]++;
                    degree[b]--;
                    graph[a].remove((Integer) b);
                    graph[b].add(a);
                }

            }

            // 위상정렬 진행
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 1; i <= N; i++) {
                if (degree[i] == 0) {
                    queue.offer(i);
                }
            }

            // 만약 시작 전 큐가 비어있다면 잘못된 case
            StringBuilder sb = new StringBuilder();
            if (queue.isEmpty()) {
                sb.append("IMPOSSIBLE");
            }

            while (!queue.isEmpty()) {
                // 한 번에 2개 이상의 내용물이 큐에 들어있다면
                // 순위 산정 불가
                if (queue.size() > 1) {
                    sb = new StringBuilder();
                    sb.append("?");
                    break;
                }

                int now = queue.poll();
                sb.append(now).append(" ");

                for (int next : graph[now]) {
                    degree[next] -= 1;
                    if (degree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }

            // 위상 정렬을 모두 마친 후에도 degree 값이 0이 아닌 요소가 있다면
            // 잘못된 case
            for (int i = 1; i <= N; i++) {
                if (degree[i] != 0) {
                    sb = new StringBuilder();
                    sb.append("IMPOSSIBLE");
                    break;
                }
            }
            System.out.println(sb.toString());

        }
    }
}
