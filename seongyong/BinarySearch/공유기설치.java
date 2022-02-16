// https://www.acmicpc.net/problem/2110

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 거리로 이분탐색 할 것!
public class 공유기설치 {
    static int N, C, result = 0, houses[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        houses = new int[N];

        for (int i = 0; i < N; i++)
            houses[i] = Integer.parseInt(br.readLine());


        Arrays.sort(houses);
        int max = houses[houses.length - 1] - houses[0];
        int min = 1;

        while (min <= max) {
            int mid = (min + max) / 2;
            int distance = houses[0];
            int cnt = 1;
            for (int i = 0; i < N; i++) {
                if (houses[i] >= distance + mid) {
                    distance = houses[i];
                    cnt++;
                }
            }
            if (cnt >= C) {
                min = mid + 1;
                result = mid;
            } else {
                max = mid - 1;
            }
        }
        System.out.println(result);
    }


}
