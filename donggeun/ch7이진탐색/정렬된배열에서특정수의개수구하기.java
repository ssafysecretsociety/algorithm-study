package ch7이진탐색;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 정렬된배열에서특정수의개수구하기 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // 존재 확인
        if (Arrays.binarySearch(numbers, x) < 0) {
            System.out.println(-1);
        } else {

            // 시작점 찾기
            int start = 0;
            int end = N - 1;
            int mid = -1;

            int left = -1;


            while (start <= end) {
                mid = (start + end) / 2;
                if (numbers[mid] < x) {
                    start = mid + 1;
                } else {
                    left = mid;
                    end = mid - 1;
                }
            }


            // 끝점 찾기
            int right = -1;
            start = 0;
            end = N - 1;
            while (start <= end) {
                mid = (start + end) / 2;
                if (numbers[mid] <= x) {
                    right = mid;
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

            System.out.println(right - left + 1);

        }


    }
}
