package ch10그래프이론;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 여행계획 {

    static int[] parents;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        parents = new int[N];
        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                // 두 도시가 연결되어 있다면 union 연산 진행
                if (map[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int now = find(Integer.parseInt(st.nextToken()));
        for (int i = 1; i < M; i++) {
            // 입력받은 계획에 대해 하나씩 find() 진행
            // 하나라도 root가 다른 노드가 있다면 종료
            if (now != find(Integer.parseInt(st.nextToken()))) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");


    }

    private static void union(int a, int b) {
        parents[find(b)] = find(a);

    }

    private static int find(int n) {
        if (n == parents[n]) return n;
        return parents[n] = find(parents[n]);

    }

}
