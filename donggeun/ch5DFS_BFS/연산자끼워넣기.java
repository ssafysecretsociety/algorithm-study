package ch5DFS_BFS;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 연산자끼워넣기 {

    static int N;
    static int[] numbers;
    static ArrayList<int[]> cases = new ArrayList<>();
    static boolean[] isSelected;

    public static void permutation(int cnt) {
        if (cnt == N - 1) {
            cases.add(Arrays.copyOf(numbers, numbers.length));
            return;
        }

        for (int i = 0; i < N - 1; i++) {
            if (isSelected[i]) continue;
            numbers[cnt] = i;
            isSelected[i] = true;
            permutation(cnt + 1);
            isSelected[i] = false;
        }
    }


    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        ArrayList<Character> op = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            int iter = Integer.parseInt(st.nextToken());
            for (int j = 0; j < iter; j++) {
                if (i == 0) {
                    op.add('+');
                } else if (i == 1) {
                    op.add('-');
                } else if (i == 2) {
                    op.add('*');
                } else {
                    op.add('/');
                }
            }
        }

        numbers = new int[N - 1];
        isSelected = new boolean[N - 1];
        permutation(0);

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int[] oneCase : cases) {
            int firstNum = list.get(0);

            for (int i = 0; i < N - 1; i++) {
                if (op.get(oneCase[i]) == '+') {
                    firstNum = firstNum + list.get(i + 1);

                } else if (op.get(oneCase[i]) == '-') {
                    firstNum = firstNum - list.get(i + 1);

                } else if (op.get(oneCase[i]) == '*') {
                    firstNum = firstNum * list.get(i + 1);

                } else {
                    // divide
                    firstNum = firstNum / list.get(i + 1);
                }
            }

            min = Math.min(min, firstNum);
            max = Math.max(max, firstNum);


        }

        System.out.println(max);
        System.out.println(min);


    }
}
