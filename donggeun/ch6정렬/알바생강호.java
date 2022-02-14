package ch6정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class 알바생강호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Integer[] tips = new Integer[N];

        for (int i = 0; i < N; i++) {
            tips[i] = Integer.parseInt(br.readLine());
        }

        // 내림차순 정렬
        // 어차피 음수부터는 돈을 못받기 때문에, 낮은 등수로 갈 수록 팁을 적게주는 사람들을 배치
        Arrays.sort(tips, Comparator.reverseOrder());

        long sum = 0;
        for (int i = 0; i < N; i++) {

            // 팁이 0이 된 시점에서 더 이상 확인 X
            if (tips[i] <= i) {
                break;
            }

            sum += tips[i] - i;
        }
        System.out.println(sum);
    }
}
