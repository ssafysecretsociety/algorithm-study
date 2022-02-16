package IM대비;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Loc {
    int up;
    int down;
    int nswe;

    public Loc(int up, int down, int nswe) {
        this.up = up;
        this.down = down;
        this.nswe = nswe;
    }

}

public class 경비원 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        int N = Integer.parseInt(br.readLine());

        Loc[] houses = new Loc[N + 1];
        Loc dg = null;
        for (int i = 0; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            if (dir <= 2) {
                // 북쪽 혹은 남쪽
                houses[i] = new Loc(dist, width - dist, dir);
            } else {
                houses[i] = new Loc(dist, height - dist, dir);
            }

            if (i == N) {
                dg = houses[i];
            }
        }

        int totalDist = 0;
        int dgDir = dg.nswe;

        for (int i = 0; i < N; i++) {
            Loc now = houses[i];

            if (dgDir <= 2 && now.nswe <= 2) {
                // dg: 북남
                // now: 북남

                if (dgDir == now.nswe) {
                    totalDist += Math.abs(dg.up - now.up);
                } else {
                    totalDist += height;
                    totalDist += Math.min(dg.up + now.up, dg.down + now.down);
                }


            } else if (dgDir <= 2) {
                // dg: 북남
                // now: 서동

                if (dgDir == 1) {
                    if (now.nswe == 3) {
                        // 북 서
                        totalDist += dg.down + now.up;
                    } else {
                        // 북 동
                        totalDist += dg.up + now.up;
                    }

                } else {
                    if (now.nswe == 3) {
                        // 남 서
                        totalDist += dg.up + now.down;
                    } else {
                        // 남 동
                        totalDist += dg.down + now.down;

                    }
                }


            } else if (now.nswe <= 2) {
                // dg: 서동
                // now: 북남

                if (dgDir == 3) {
                    if (now.nswe == 1) {
                        // 서 북
                        totalDist += dg.up + now.up;

                    } else {
                        // 서 남
                        totalDist += dg.down + now.up;

                    }
                } else {
                    if (now.nswe == 1) {
                        // 동 북
                        totalDist += dg.up + now.down;

                    } else {
                        // 동 남
                        totalDist += dg.down + now.down;

                    }
                }

            } else {
                // dg: 동서
                // now: 동서
                if (dgDir == now.nswe) {
                    totalDist += Math.abs(dg.up - now.up);
                } else {
                    totalDist += width;
                    totalDist += Math.min(dg.up + now.up, dg.down + now.down);
                }
            }


        }

        System.out.println(totalDist);

    }
}
