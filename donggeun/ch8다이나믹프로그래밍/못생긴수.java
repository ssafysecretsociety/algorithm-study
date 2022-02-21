package ch8다이나믹프로그래밍;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 못생긴수 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] multi = {2, 3, 5}; // 반복문 활용을 위한 int[]
        PriorityQueue<Integer> hq = new PriorityQueue<>(); // 순서를 정렬해줄 Heap Queue
        HashMap<Integer, Boolean> hm = new HashMap<>(); // 숫자가 등장했었는지 확인할 HashMap
        ArrayList<Integer> list = new ArrayList<>(); // 못생긴 수들이 저장 될 ArrayList

        // 초기값인 1에 대한 처리
        hm.put(1, true);
        hq.offer(1);

        int number = 1;

        // N번째 수에 도달할 때까지 반복
        while (list.size() < N) {
            number = hq.poll();
            list.add(number);

            // multi 배열의 {2, 3, 5}에 대하여
            // 현재 수에 2, 3, 5를 곱한 값이 아직 등장하지 않았다면
            // 힙큐에 추가, 해쉬맵에 추가
            for (int i = 0; i < 3; i++) {
                if (hm.get(number * multi[i]) == null) {
                    hq.offer(number * multi[i]);
                    hm.put(number * multi[i], true);
                }
            }
        }
        
        // N번째 못생긴 수 출력
        System.out.println(number);

    }
}
