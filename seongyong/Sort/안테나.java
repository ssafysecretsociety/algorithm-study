// https://www.acmicpc.net/problem/18310

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 안테나 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] houses = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            houses[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(houses);
        System.out.println(houses[(houses.length - 1)/2]);
    }
}
