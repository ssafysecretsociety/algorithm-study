// p.316 무지의 먹방라이브
// 프로그래머스 42891

package ch3Greedy;

public class MuziLive {
    public static void main(String[] args) {
        System.out.println(new MuziLive().solution(new int[]{1, 100}, 10));
    }

    public static boolean isEmpty(int[] food_times) {
        boolean isEmpty = true;
        for (int i = 0; i < food_times.length; i++) {
            if (food_times[i] > 0) {
                isEmpty = false;
            }
        }
        return isEmpty;

    }

    public int solution(int[] food_times, long k) {
        int cursor = 0;
        for (int i = 0; i < k; i++) {

            if (isEmpty(food_times)) {
                return -1;
            }

            while (food_times[cursor] == 0) {
                cursor = (cursor + 1) % food_times.length;
            }
            food_times[cursor] -= 1;
            cursor = (cursor + 1) % food_times.length;
        }

        if (isEmpty(food_times)) {
            return -1;
        }

        while (food_times[cursor] == 0) {
            cursor = (cursor + 1) % food_times.length;
        }

        return cursor + 1;
    }
}
