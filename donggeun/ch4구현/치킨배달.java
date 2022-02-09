// p.332 치킨 배달
// bj 15686
// https://www.acmicpc.net/problem/15686

package ch4구현;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class 치킨배달 {

    static ArrayList<int[]> cases = new ArrayList<>();
    static int[] index;
    static int N, M;
    static int chickenCount;

    public static void combination(int cnt, int start) {
        if (cnt == M) {
            cases.add(Arrays.copyOf(index, index.length));
            return;
        }

        for (int i = start; i < chickenCount; i++) {
            index[cnt] = i;
            combination(cnt + 1, i + 1);
        }

    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];

        ArrayList<int[]> chickens = new ArrayList<>();
        ArrayList<int[]> houses = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    chickens.add(new int[]{i, j});
                } else if (map[i][j] == 1) {
                    houses.add(new int[]{i, j});
                }
            }
        }

        chickenCount = chickens.size();

        index = new int[M];
        combination(0, 0);
        int shortestCase = Integer.MAX_VALUE;
        for (int[] ints : cases) {
            // ints = [0,1,2] [0,1,4]
            int total = 0;
            for (int[] house : houses) {
                // 각 하우스에 대해서...
                int shortest = Integer.MAX_VALUE;
                for (int i = 0; i < ints.length; i++) {
                    int[] nowChicken = chickens.get(ints[i]);
                    int dist = Math.abs(house[0] - nowChicken[0]) + Math.abs(house[1] - nowChicken[1]);
                    if (dist < shortest) {
                        shortest = dist;
                    }
                }
                total += shortest;
            }
            if (total < shortestCase) {
                shortestCase = total;
            }
        }
        System.out.println(shortestCase);


    }

}
