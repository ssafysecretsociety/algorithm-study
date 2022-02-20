// https://www.acmicpc.net/submit/2309

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2309_일곱난쟁이 {
    static int N = 9, K = 2;
    static int[] numbers, input;
    static ArrayList<int[]> arrayList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        input = new int[N];
        numbers = new int[K];

        int total = 0;
        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
            total += input[i];
        }

        comb(0, 0);

        Arrays.sort(input);
        int[] remove = new int[K];
        for (int i = 0; i < arrayList.size(); i++) {
            int sum = 0;
            int[] tmp = arrayList.get(i);
            for (int j = 0; j < tmp.length; j++)
                sum += tmp[j];

            if((total - sum) == 100)
                remove = tmp;

        }

        for (int i = 0; i < input.length; i++) {
            if(input[i] == remove[0] || input[i] == remove[1] )
                continue;
            else {
                System.out.println(input[i]);
            }
        }
    }

    public static void comb(int cnt, int start) {
        if (cnt == K) {
            arrayList.add(Arrays.copyOf(numbers, numbers.length));
            return;
        }

        for (int i = start; i < N; i++) {
            numbers[cnt] = input[i];
            comb(cnt + 1, start + 1);
        }
    }
}
