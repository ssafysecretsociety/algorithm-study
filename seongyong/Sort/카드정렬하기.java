// https://www.acmicpc.net/problem/1715

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 카드정렬하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            queue.offer(Integer.parseInt(st.nextToken()));
        }

        int cnt = 0;
        while (queue.size() > 1) {
            int a = queue.poll();
            int b = queue.poll();
            cnt += a+b;
            queue.offer(a + b);
        }


        System.out.println(cnt);
    }
}
