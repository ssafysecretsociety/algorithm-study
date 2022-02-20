// https://www.acmicpc.net/problem/2564

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2564_경비원 {
    static int R, C, result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 가로 세로 길이
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        // 가게 수
        int N = Integer.parseInt(br.readLine());
        ArrayList<int[]> shops = new ArrayList<>();

        // input
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            shops.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        // 이동근
        st = new StringTokenizer(br.readLine());
        int[] dong = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

        for (int i = 0; i < N; i++) {
            // 건너편에 있을 경우
            int[] shop = shops.get(i);
            if (Math.abs(dong[0] - shop[0]) == 1 && !(dong[0] == 2 && shop[0] == 3) && !(dong[0] == 3 && shop[0] == 2))
                across(dong, shop);

            // 같은 방향일 경우
            else if(dong[0] == shop[0]){
                result += Math.abs(dong[1] - shop[1]);
            }
            // 옆에 있을 경우
            else
                side(dong, shop);
        }
        System.out.println(result);
    }

    static void across(int[] dong, int[] shop) {
        int offset;
        int opposite;

        // 동근이랑 가게가 위아래로 있으면
        if (dong[0] == 1 || dong[0] == 2) {
            offset = C;
            opposite = R;
        }
        // 동근이랑 가게가 양옆으로 있으면
        else {
            offset = R;
            opposite = C;
        }

        // offset 값은 무조건 더해진다
        int sum = offset;

        // 가로의 길이는 동근, 가게의 양쪽의 합 중에서
        // 최솟값을 더해준다
        int a = (dong[1] + shop[1]);
        int b = (opposite - dong[1] + opposite - shop[1]);
        sum += Math.min((dong[1] + shop[1]), (opposite - dong[1] + opposite - shop[1]));

        result += sum;
    }

    static void side(int[] dong, int[] shop) {
        // 동근 북
        if (dong[0] == 1) {
            if (shop[0] == 3)
                result += (dong[1] + shop[1]);
            else
                result += (R - dong[1] + shop[1]);
        }
        // 동근 남
        else if (dong[0] == 2) {
            if (shop[0] == 3)
                result += (dong[1] + C - shop[1]);
            else
                result += (R - dong[1] + C - shop[1]);
        }
        // 동근 서
        else if (dong[0] == 3) {
            if (shop[0] == 1)
                result += (dong[1] + shop[1]);
            else
                result += (C - dong[1] + shop[1]);
        }
        // 동근 동
        else if (dong[0] == 4) {
            if (shop[0] == 1)
                result += (dong[1] + R - shop[1]);
            else
                result += (C - dong[1] + R - shop[1]);
        }
    }
}
