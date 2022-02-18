package IM대비;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 줄세우기 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        LinkedList<Integer> line = new LinkedList<>();
        for (int i = 0; i < N; i++) {

            // 현재 LinkedList의 길이 - 학생의 뽑은 숫자위치에 학생의 인덱스 삽입
            int number = Integer.parseInt(st.nextToken());
            line.add(line.size() - number, i + 1);

        }

        StringBuilder sb = new StringBuilder();
        for (int i : line) {
            sb.append(i).append(" ");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb.toString());


    }
}
