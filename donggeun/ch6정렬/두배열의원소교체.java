package ch6정렬;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 두배열의원소교체 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Integer[] arrA = new Integer[N];
        Integer[] arrB = new Integer[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        // 입력받은 두개의 배열을 하나는 오름차순, 하나는 내림차순으로 정렬
        Arrays.sort(arrA);
        Arrays.sort(arrB, Comparator.reverseOrder());

        // K회 반복
        for (int i = 0; i < K; i++) {
            int a = arrA[i];
            int b = arrB[i];

            // 더 이상 바꿀 필요가 없어졌다면 break
            if (a >= b) {
                break;
            }

            arrA[i] = b;
        }

        int sum = 0;
        for (int i : arrA) {
            sum += i;
        }

        System.out.println(sum);

    }
}
