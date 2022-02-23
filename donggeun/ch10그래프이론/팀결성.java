package ch10그래프이론;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class 팀결성 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] parents = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < M; i++) {
            int cmd = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            // 0일 경우 union
            if (cmd == 0) {
                union(parents, a, b);
            } else {
                // 1일경우 find를 해서 같은 값이 나오면 YES
                if (find(a, parents) == find(b, parents)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }

        }

    }

    private static int find(int n, int[] parents) {
        if (n == parents[n]) {
            return n;
        }

        return parents[n] = find(parents[n], parents);
    }

    private static void union(int[] parents, int a, int b) {
        parents[find(a, parents)] = find(b, parents);
    }
}
