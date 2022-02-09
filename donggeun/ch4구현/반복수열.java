// bj 2331 반복수열
// https://www.acmicpc.net/problem/2331


package ch4구현;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class 반복수열 {

    // D[n+1]을 구해주는 메서드
    public static int getNextNumber(int num, int p) {
        String str = String.valueOf(num);
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            int digit = Character.digit(str.charAt(i), 10);
            sum += Math.pow(digit, p);
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int P = sc.nextInt();

        // 방문여부 확인을 위한 HashMap, 지금까지 등장한 숫자들을 저장할 Stack
        HashMap<Integer, Boolean> hm = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        int next = A;

        while (true) {
            stack.add(next);
            hm.put(next, true);

            next = getNextNumber(next, P);

            // 등장했던 숫자라면
            if (hm.containsKey(next)) {

                // stack에 반복 된 수가 등장할 때 까지 pop
                while (!stack.isEmpty()) {
                    if (next == stack.pop()) {
                        break;
                    }
                }
                break;
            }
        }
        System.out.println(stack.size());
    }
}
