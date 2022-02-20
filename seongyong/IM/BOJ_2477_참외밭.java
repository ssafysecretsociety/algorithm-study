// https://www.acmicpc.net/problem/2477

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2477_참외밭 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int offset = Integer.parseInt(br.readLine());

        // 가로 길이들을 저장할 배열
        ArrayList<Integer> row = new ArrayList<>();

        // 세로 길이들을 저장할 배열
        ArrayList<Integer> col = new ArrayList<>();

        // 전체를 저장할 큐
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());

            int dir = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            if (dir == 3 || dir == 4)
                row.add(distance);
            else
                col.add(distance);

            queue.offer(distance);
        }
        // 가로 길이의 최댓값
        Collections.sort(row, Collections.reverseOrder());
        int rowMax = row.get(0);

        // 세로 길이의 최댓값
        Collections.sort(col, Collections.reverseOrder());
        int colMax = col.get(0);

        // 한짤린 사각형 전체 면적
        int square = rowMax * colMax;


        // 큐를 돌리면서 가로 혹은 세로의 최댓값중 하나가 맨 앞으로 올때까지 반복!
        // 최댓값은 무조건 연속해서 들어오기 때문에 (ㄱ, ㄴ 형태여서) 최댓값 두개를 연속 제거
        // 그렇게 되면 자연스럽게 가운데 두개의 숫자가 잘라낼 사각형의 가로 세로이다.
        while (true) {
            if (!queue.contains(rowMax) && !queue.contains(colMax))
                break;
            if (queue.peek() == rowMax || queue.peek() == colMax)
                queue.poll();
            else
                queue.offer(queue.poll());
        }

        // 남은 큐의 4개 중에서 가운데 두개가 제거해야할 면적의 가로 세로가 된다
        queue.poll();

        int result = square - (queue.poll() * queue.poll());
        System.out.println(result * offset);
    }
}
