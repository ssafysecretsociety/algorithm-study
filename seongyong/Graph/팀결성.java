import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 팀결성 {
    static int N, M;
    static int[] parents;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parents = new int[N + 1];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int type = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            switch (type) {
                case 0:
                    union(a, b);
                    break;

                case 1:
                    if (findSet(a) == findSet(b))
                        sb.append("Yes").append("\n");
                    else
                        sb.append("NO").append("\n");

                    break;
            }
        }
        System.out.println(sb.toString().trim());
    }

    public static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);

        if (aRoot == bRoot)
            return false;

        if (aRoot < bRoot)
            parents[bRoot] = aRoot;
        else
            parents[aRoot] = bRoot;

        return true;
    }

    public static int findSet(int a) {
        if (a == parents[a])
            return a;
        return parents[a] = findSet(parents[a]);

    }
}

/*
7 8
0 1 3
1 1 7
0 7 6
1 7 1
0 3 7
0 4 2
0 1 1
1 1 1

 */