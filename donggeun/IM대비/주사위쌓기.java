package IM대비;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 주사위쌓기 {

    static int sum; // 하나의 케이스에 대한 sum을 저장할 변수
    static int max; // 가장 큰 경우가 담길 변수
    static int[][] map; // 주사위 입력
    static HashMap<Integer, Integer> hm = new HashMap<>(); // 반대편 주사위의 위치를 알려주는 HashMap

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // hm 초기화
        hm.put(0, 5);
        hm.put(5, 0);
        hm.put(1, 3);
        hm.put(3, 1);
        hm.put(2, 4);
        hm.put(4, 2);

        int N = Integer.parseInt(br.readLine());

        map = new int[N][6];
        StringTokenizer st = null;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 가장 밑면의 인덱스가 0~5인 경우 모두 실험
        for (int j = 0; j < 6; j++) {
            sum = 0;
            int n = j;

            // 주사위 개수만큼 반복 수행
            for (int i = 0; i < N; i++) {
                sum += getLarge(n, map[i]); // 현재 줄에서 가장 큰 수를 받아 sum에 더해줌

                // 마지막 주사위에 대해서 다음 주사위 탐색 X
                if (i == N - 1) break;
                n = findIndex(map[i][hm.get(n)], map[i + 1]); // 다음에 밑면이 될 값이 다음 배열에서 몇번째 인덱스인지 확인
            }
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }

    // 값으로 받은 수가 몇번째 인덱스인지 반환해주는 메서드
    private static int findIndex(int value, int[] numbers) {
        for (int i = 0; i < 6; i++) {
            if (numbers[i] == value) {
                return i;
            }
        }
        return -1;
    }

    // 주어진 밑면의 인덱스를 토대로, 밑면과 윗면에 들어갈 수를 제외한 가장 큰 수를 찾기
    private static int getLarge(int bottomIndex, int[] numbers) {
        int upIndex = hm.get(bottomIndex);

        int max = 0;
        for (int i = 0; i < 6; i++) {
            if (i == bottomIndex || i == upIndex) continue;
            max = Math.max(max, numbers[i]);
        }

        return max;
    }
}
