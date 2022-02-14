package ch6정렬;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 카드정렬하기 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        // PriorityQueue를 이용해 힙정렬
        // 가장 작은 두개의 더미를 꺼내 합치고 그 값을 sum에 추가
        // 합쳐진 더미는 다시 pq에 삽입
        int sum = 0;
        while (pq.size() > 1) {
            int sumOfTwo = pq.poll() + pq.poll();
            sum += sumOfTwo;
            pq.offer(sumOfTwo);
        }


        System.out.println(sum);

    }
}
