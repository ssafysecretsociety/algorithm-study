package IM대비;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스위치켜고끄기 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] switches = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }

        int studentN = Integer.parseInt(br.readLine());
        int[][] students = new int[studentN][2];

        // 학생들을 int[][]에 저장
        for (int i = 0; i < studentN; i++) {
            st = new StringTokenizer(br.readLine());
            students[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        // 각 학생에 대하여
        for (int[] student : students) {
            int gender = student[0];
            int no = student[1];

            // 성별이 남자일 경우, 배수들을 전부 교체
            if (gender == 1) {
                for (int i = 1; i <= N / no; i++) {
                    if (switches[i * no] == 0) {
                        switches[i * no] = 1;
                    } else {
                        switches[i * no] = 0;
                    }
                }

            } else {

                // 성별이 여자인 경우, 가운데부터 한 칸씩 늘려가며 대칭이면 교체
                int i = 0;
                while (true) {
                    if (no - i < 1 || no + i > N) {
                        break;
                    }

                    if (switches[no - i] != switches[no + i]) {
                        break;
                    }

                    if (switches[no - i] == 1) {
                        switches[no - i] = 0;
                        switches[no + i] = 0;
                    } else {
                        switches[no - i] = 1;
                        switches[no + i] = 1;
                    }
                    i++;
                }
            }


        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(switches[i]).append(" ");
            if (i % 20 == 0) {
                sb.append("\n");
            }
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb.toString());

    }
}
