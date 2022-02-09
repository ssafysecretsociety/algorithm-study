import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 게임개발 {
    // 반시계 방향 idx = 0 북쪽
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};

    final static int SEA = 1;
    final static int LAND = 0;

    static ArrayList<int[]> move = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int locX = sc.nextInt();
        int locY = sc.nextInt();
        int dir = sc.nextInt();

        int[][] map = new int[N][M];
        for (int r = 0; r < N ; r++) {
            for (int c = 0; c < M ; c++) {
                map[r][c] = sc.nextInt();
            }
        }

        // 첫 위치 초기화
        move.add(new int[]{locX, locY});

        int cnt = 1;
        while(true){
            dir = turn(dir);
            int nx = locX + dx[dir];
            int ny = locX + dy[dir];

            if(nx > N || nx < 0 || ny > M || ny < 0){
                cnt++;
                continue;
            }
            // 제자리에서 한바퀴를 다 돌았을 경우
            if (cnt == 4){
                // 뒤로 한 칸
                nx = locX - dx[dir];
                ny = locY - dy[dir];

                // 뒤가 바다가 아니고 방문한 타일이 아닐 경우
                if ( !move.contains(new int[]{nx, ny}) && map[nx][ny] != SEA ){
                    move.add(new int[]{nx,ny});
                    locX = nx;
                    locY = ny;
                    cnt = 1;
                    continue;
                }

                //종료 조건
                else
                    break;
            }

            // 육지를 만났을 경우
            if ( !move.contains(new int[]{nx, ny}) && map[nx][ny] != SEA ){
                move.add(new int[]{nx,ny});
                locX = nx;
                locY = ny;
                cnt = 1;
                continue;
            }
            // 바다를 만났을 경우
            else if (map[nx][ny] == SEA){
                cnt++;
                continue;
            }
        }

        System.out.println(move.size());

    }

    static int turn(int dir){
        return (dir + 1) % 4;
    }
}
