// https://www.acmicpc.net/problem/18352
// 83% 실패,,

import java.util.*;

public class 특정거리의도시찾기 {
    static int N, M, K, X;
    static ArrayList<ArrayList<Integer>> map = new ArrayList<>();
    static Queue<Integer> queue = new LinkedList<>();
    static int[] distacne ;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        X = sc.nextInt();

        distacne = new int[N];
        for (int i = 0; i < N; i++)
            map.add(i, new ArrayList<>());


        for (int i = 0; i < M; i++) {
            int ver = sc.nextInt()-1;
            int next = sc.nextInt()-1;
            map.get(ver).add(next);
        }
        bfs();

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if(distacne[i] == K){
                cnt ++;
                System.out.println(i+1);
            }
        }

        if(cnt == 0)
            System.out.println(-1);
    }


    static void bfs() {
        queue.offer(X-1);

        while(!queue.isEmpty()){
            int q = queue.poll();

            if(!map.get(q).isEmpty()){
                for (int i = 0; i < map.get(q).size(); i++) {
                    int nextVertex = map.get(q).get(i);
                    if(distacne[nextVertex] == 0){
                        distacne[nextVertex] = distacne[q]+1;
                        queue.offer(nextVertex);
                    }
                }
            }
        }
    }
}
