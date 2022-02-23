package ch10그래프이론;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class 커리큘럼 {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] times = new int[N + 1];
        int[] degree = new int[N + 1];
        ArrayList<Integer>[] list = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            times[i] = sc.nextInt();
            list[i] = new ArrayList<>();
            while (true) {
                int before = sc.nextInt();
                if (before == -1) break;
                degree[i]++;
                list[before].add(i);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }

        // 위상정렬 진행
        int[] result = times.clone();
        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int i = 0; i < list[now].size(); i++) {
                int next = list[now].get(i);

                // result값 갱신
                // 현재 담겨있는 값 vs 기존 수업 듣는데 필요한 시간 + 선행수업 시간
                result[next] = Math.max(result[next], result[now] + times[next]);
                degree[next] -= 1;
                if (degree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        System.out.println(Arrays.toString(result));


    }

}
