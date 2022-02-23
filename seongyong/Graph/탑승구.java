import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 탑승구 {
    static int G, P, parents[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        G = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());
        parents = new int[G + 1];

        for (int i = 1; i < G + 1; i++) {
            parents[i] = i;
        }

        int result = 0;
        for (int i = 0; i < P; i++) {
            int air = Integer.parseInt(br.readLine());
            // 부모를 찾았는데 0 이면 사이 공항 폐쇄
            if(findSet(air) == 0)
                break;
            union(findSet(air), findSet(air)-1);
            result ++;
        }
        System.out.println(result);
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
