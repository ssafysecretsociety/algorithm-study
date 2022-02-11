package ch5DFS_BFS;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 특정거리의도시찾기 {

    static ArrayList<ArrayList<Integer>> map = new ArrayList<>();
    static int N;
    static int K;
    static ArrayList<Integer> city;
    static int[] distance;

    public static void bfs(int start) {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowCity = now[0];
            int nowDist = now[1];

            if (nowDist == K) {
                // TODO: 도시 방문한 적이 없는지 확인
                city.add(nowCity + 1);
            } else {
                // nowDist < K
                ArrayList<Integer> info = map.get(nowCity);
                for (int i = 0; i < info.size(); i++) {
                    if (distance[info.get(i)] == -1) {
                        distance[info.get(i)] = nowDist + 1;
                        queue.offer(new int[]{info.get(i), nowDist + 1});
                    }
                }
            }
        }

    }


    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        distance = new int[N];
        distance[X - 1] = 0;


        for (int i = 0; i < N; i++) {
            distance[i] = -1;
            map.add(new ArrayList<>());
        }

        int start = -1;
        int end = -1;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            map.get(start - 1).add(end - 1);
        }

        city = new ArrayList<>();

        bfs(X - 1);

        Collections.sort(city);

        if (city.isEmpty()) {
            System.out.println(-1);
        } else {
            for (int i : city) {
                System.out.println(i);
            }
        }


    }
}
