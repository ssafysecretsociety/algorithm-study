package ch6정렬;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// Comparable 인터페이스를 구현한 Student 클래스 선언
class StudentA implements Comparable<StudentA> {
    String name;
    int score;

    public StudentA(String name, int score) {
        this.name = name;
        this.score = score;
    }

    // 점수 오름차순
    @Override
    public int compareTo(StudentA o) {
        return Integer.compare(this.score, o.score);
    }
}


public class 성적이낮은순서로학생출력하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StudentA[] students = new StudentA[N];

        StringTokenizer st = null;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            students[i] = new StudentA(st.nextToken(), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(students);

        for (StudentA s : students) {
            System.out.print(s.name + " ");
        }
        System.out.println();


    }
}

