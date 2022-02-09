// https://programmers.co.kr/learn/courses/30/lessons/42891

public class 무지의먹방라이브 {

    // 효율성 에러!
    public static int solution(int[] food_times, long k) {
        // k초 후에 음식이 남지 않을 경우
        int total = 0;
        for (int i = 0; i < food_times.length; i++)
            total += food_times[i];

        if (total < k)
            return -1;

        int time = 0;
        int idx = 0;
        while (true) {
            if (time == k)
                break;
            if (food_times[idx] > 0) {
                food_times[idx++]--;
                time++;
            } else
                idx++;


            idx %= food_times.length;
        }

        while (true)
            if (food_times[idx++] != 0)
                break;

        return idx;
    }


    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 1, 1, 1, 2, 4, 3}, 12));
        System.out.println(solution(new int[]{4, 3, 5, 6, 2}, 7));
        System.out.println(solution(new int[]{3, 1, 2}, 5));
    }
}
