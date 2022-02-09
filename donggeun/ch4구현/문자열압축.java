// p.323 문자열 압축
// 프로그래머스 60057
// https://programmers.co.kr/learn/courses/30/lessons/60057

package ch4구현;

import java.util.ArrayList;
import java.util.Stack;

public class 문자열압축 {

    public static void main(String[] args) {
        System.out.println(new 문자열압축().solution("a"));
    }

    public int solution(String s) {
        int length = s.length();
        int shortest = Integer.MAX_VALUE;

        if (length == 1) return 1;

        for (int i = 1; i <= length / 2; i++) {
            // i: 반복 문자 단위
            String prev = "";
            String now = "";

            Stack<String> stack = new Stack<>();
            ArrayList<Integer> counts = new ArrayList<>();

            for (int j = 0; j < length; j += i) {
                if (j + i < length) {
                    now = s.substring(j, j + i);
                } else {
                    now = s.substring(j);
                }

                if (stack.isEmpty()) {
                    stack.add(now);
                    counts.add(1);
                } else {
                    if (now.equals(stack.peek())) {
                        // 이전 문자열과 현재가 같음
                        counts.set(counts.size() - 1, counts.get(counts.size() - 1) + 1);
                    } else {
                        // 이전 문자열과 현재가 다름
                        stack.add(now);
                        counts.add(1);
                    }
                }
            }

            int sum = 0;
            for (String str : stack) {
                sum += str.length();
            }
            for (int count : counts) {
                if (count == 1) {
                    continue;
                } else if (count < 10) {
                    sum += 1;
                } else if (count < 100) {
                    sum += 2;
                } else if (count < 1000) {
                    sum += 3;
                } else {
                    sum += 4;
                }
            }

            if (sum < shortest) {
                shortest = sum;
            }

        }
        return shortest;
    }
}
