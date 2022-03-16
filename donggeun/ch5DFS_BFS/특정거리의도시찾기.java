package ch5DFS_BFS;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 특정거리의도시찾기 {

    static int N;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        List<Integer>[] map = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            map[from].add(to);
        }

        List<Integer> cities = bfs(map, K, X);
        Collections.sort(cities);

        if (cities.isEmpty()) {
            System.out.println(-1);
        } else {
            for (int city : cities) {
                System.out.println(city);
            }
        }


    }

    static List<Integer> bfs(List[] map, int dist, int start) {
        boolean[] isVisited = new boolean[N + 1];

        List<Integer> cities = new ArrayList<>();

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int from = now[0];
            int count = now[1];
            if (count == dist) {
                if (!isVisited[from]) {
                    isVisited[from] = true;
                    cities.add(from);
                }
                continue;
            } else if (count > dist) {
                break;
            }
            isVisited[from] = true;

            for (int i = 0; i < map[from].size(); i++) {
                if (isVisited[(int) map[from].get(i)]) continue;
                queue.offer(new int[]{(int) map[from].get(i), count + 1});
            }
        }

        return cities;
    }
}