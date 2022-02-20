// https://www.acmicpc.net/problem/2605

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2605_줄세우기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] nums = new int[N];
        for (int i = 0; i < N; i++)
            nums[i] = Integer.parseInt(st.nextToken());

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < N; i++)
            result.add(i-nums[i], i+1);

        StringBuilder sb = new StringBuilder();
        for (int r: result)
            sb.append(r).append(" ");

        System.out.println(sb.toString().trim());
    }
}
