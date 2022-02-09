// https://www.acmicpc.net/problem/3190

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Snake {
    int[] head;
    int[] tail;
    String dir;
    ArrayList<int[]> body;

    public Snake() {
        this.head = new int[]{0,0};
        this.tail = new int[]{0,0};
        this.dir = "R";
        this.body = new ArrayList<>();
        this.addBody(new int[]{0,0});
    }

    void addBody(int[] arr) {
        this.body.add(0, arr);
    }
    void removeBody() {
        this.body.remove(body.size()-1);
    }

    void print(){
        for (int i = 0; i < body.size(); i++) {
            System.out.print(Arrays.toString(body.get(i)) + " ");

        }
    }


    // 기본 제공 contains 함수는 배열의 주소값을 참조 하여 값 비교에 실패
    boolean contain(int[] arr){
        for (int i = 0; i<body.size(); i++){
            int[] origin = body.get(i);
            if(origin[0] == arr[0] && origin[1] == arr[1])
                return true;
        }
        return false;
    }
}

public class 뱀 {
    final static int APPLE = 1;
    static int[][] board;
    static int N, K, CNT, second;
    static Snake snake;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());    // 칸
        K = Integer.parseInt(br.readLine());    // 사과
        board = new int[N][N];  // board


        // 사과 입력
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            board[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = APPLE;
        }

        // init
        snake = new Snake();
        CNT = Integer.parseInt(br.readLine());    // 명령어 수
        Map<Integer, String> move = new HashMap<>();    // 명령어 리스트
        for (int i = 0; i < CNT; i++) {
            st = new StringTokenizer(br.readLine());
            move.put(Integer.parseInt(st.nextToken()), st.nextToken());
        }

        // start
        for(second = 1; second<= 10000; second++){
            String dir = snake.dir;
            boolean end = false;

            // 해당하는 초에 방향 전환이 있을 때
            if(move.containsKey(second))
                handling(move.get(second));

            if(dir.equals("R"))
                end = moveSnake(0,1);
            else if(dir.equals("L"))
                end = moveSnake(0,-1);
            else if(dir.equals("U"))
                end = moveSnake(-1,0);
            else
                end = moveSnake(1,0);

            if (end)
                break;

        }

        System.out.println(second);
    }

    static boolean moveSnake(int dx, int dy){
        int nx = snake.head[0] + dx;
        int ny = snake.head[1] + dy;

        // 벽이 있는 경우 종료
        if(nx < 0 || ny < 0 || ny >= N || nx >=N) return true;

        // 다음에 이동할 타일
        int[] next = {nx, ny};

        // 자기 자신을 만나는 경우 종료
        if (snake.contain(next)) return true;

        // 사과를 섭취하며 이동
        if (board[nx][ny] == 1){
            snake.head = next; // head 변경
            snake.addBody(next); // 바디 추가
            board[nx][ny] = 0; // board 사과 제거
        }

        // 사과를 섭취하지 못하고 이동
        else{
            snake.head = next; // head 변경
            snake.addBody(next); // 바디 추가
            snake.removeBody();
            snake.tail = snake.body.get(snake.body.size()-1); // tail 변경
        }

        return false;
    }


    static void handling(String handle){
        if (handle.equals("L")){
            if(snake.dir.equals("R")) snake.dir = "U";
            else if(snake.dir.equals("L")) snake.dir = "D";
            else if(snake.dir.equals("U")) snake.dir = "L";
            else  snake.dir = "R";
        }

        else if (handle.equals("D")){
            if(snake.dir.equals("R")) snake.dir = "D";
            else if(snake.dir.equals("L")) snake.dir = "U";
            else if(snake.dir.equals("U")) snake.dir = "R";
            else  snake.dir = "L";
        }
    }
}
