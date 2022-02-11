package ch5DFS_BFS;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Virus implements Comparable<Virus> {

    int virusNo;
    int x;
    int y;
    int time;

    public Virus(int virusNo, int x, int y, int time) {
        this.virusNo = virusNo;
        this.x = x;
        this.y = y;
        this.time = time;
    }


    @Override
    public int compareTo(Virus o) {
        return this.virusNo - o.virusNo;
    }
}

public class 경쟁적전염 {

    static int N, K, S, X, Y, map[][];
    static Queue<Virus> virus = new LinkedList<>();


    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());


        map = new int[N][N];
        ArrayList<Virus> virusList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) {
                    virusList.add(new Virus(map[i][j], i, j, 0));
                }
            }
        }

        Collections.sort(virusList);

        for (int i = 0; i < virusList.size(); i++) {
            virus.offer(virusList.get(i));
        }


        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        Virus now = null;
        int virusNo = -1, x = -1, y = -1, time = -1, nx = -1, ny = -1;
        while (!virus.isEmpty()) {
            now = virus.poll();
            virusNo = now.virusNo;
            x = now.x;
            y = now.y;
            time = now.time;

            if (time == S) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                nx = x + dx[i];
                ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }

                if (map[nx][ny] != 0) {
                    continue;
                }

                map[nx][ny] = virusNo;
                virus.offer(new Virus(virusNo, nx, ny, time + 1));
            }


        }

        System.out.println(map[X - 1][Y - 1]);

    }
}
