import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 커리큘럼 {
    static int N, indegree[], time[];
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        indegree = new int[N + 1];
        time = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            time[i] = t;

            int v = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens() && v != -1) {
                indegree[i] += 1;
                graph.get(v).add(i);
                v = Integer.parseInt(st.nextToken());
            }
        }

        topology();

    }

    public static void topology() {
        int[] result = Arrays.copyOf(time, time.length);
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < N + 1; i++) {
            if (indegree[i] == 0)
                queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int i : graph.get(now)) {
                result[i] = Math.max(result[i], result[now] + time[i]);
                indegree[i] -= 1;
                if (indegree[i] == 0)
                    queue.add(i);
            }
        }

        for (int i = 1; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }
}

/*
5
10 -1
10 1 -1
4 1 -1
4 3 1 -1
3 3 -1
 */