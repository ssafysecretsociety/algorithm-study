package ch7이진탐색;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 고정점찾기 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = N - 1;
        int mid = -1;
        int result = -1;

        while (start <= end) {
            mid = (start + end) / 2;
            if (numbers[mid] == mid) {
                result = mid;
                break;
            } else if (numbers[mid] < mid) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(result);

    }
}
