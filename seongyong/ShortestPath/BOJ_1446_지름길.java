// https://www.acmicpc.net/problem/1446

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_1446_지름길 {
    static class Gil implements Comparable<Gil> {
        int start;
        int end;
        int cost;

        public Gil(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }


        // 끝을 기준으로 정렬
        @Override
        public int compareTo(Gil o) {
            if (this.end == o.end)
                return this.cost - o.cost;
            return this.end - o.end;
        }
    }

    static int N, D, depth, result;
    static int ne = 0, now = 0;
    static ArrayList<Gil> gils = new ArrayList<>();
    static boolean isVisited[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        D = sc.nextInt();

        depth = 0;
        for (int i = 0; i < N; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int c = sc.nextInt();
            if (e > D)
                continue;

            gils.add(new Gil(s, e, c));
            depth++;
        }
        Collections.sort(gils);
        result = D;

        isVisited = new boolean[depth];
//        dfs(0, 0, 0, 0);
        subset(0);
        System.out.println(result);
    }

//    public static void dfs(int cnt, int start, int ne, int now) {
//        if (cnt == depth) {
//            if (ne < D) {
//                now += (D - ne);
//            }
//            result = Math.min(result, now);
//            return;
//        }
//
//        if (now > result)
//            return;
//
//
//
//        for (int i = start; i < depth; i++) {
//            Gil ng = gils.get(i);
//            if (ne <= ng.start) {
//                now += ng.cost;
//                ne = ng.end;
//            }
//            dfs(cnt + 1, i + 1, ne, now);
//        }
//    }


    public static void subset(int cnt) {
        if (cnt == depth) {
            for (int i = 0; i < depth; i++) {
                if (isVisited[i]) {
                    Gil ng = gils.get(i);
                    if (ne <= ng.start) {
                        now += ng.cost;
                        now += ng.start - ne;
                        ne = ng.end;
                    }
                }
            }

            now += (D - ne);
            result = Math.min(result, now);
            now = 0;

            return;
        }

        isVisited[cnt] = true;
        subset(cnt + 1);

        isVisited[cnt] = false;
        subset(cnt + 1);
    }

}
