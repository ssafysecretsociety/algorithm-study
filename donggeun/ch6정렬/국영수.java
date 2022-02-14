package ch6정렬;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// Comparable 인터페이스를 구현한 Student 클래스 정의
class Student implements Comparable<Student> {
    String name;
    int korean;
    int english;
    int math;

    public Student(String name, int korean, int english, int math) {
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
    }

    @Override
    public int compareTo(Student o) {
        // 1차: 국어 점수 내림차순
        if (this.korean != o.korean) {
            return Integer.compare(o.korean, this.korean);
        }

        // 2차: 영어 점수 오름차순
        if (this.english != o.english) {
            return Integer.compare(this.english, o.english);
        }

        // 3차: 수학 점수 내림차순
        if (this.math != o.math) {
            return Integer.compare(o.math, this.math);
        }

        // 4차: 이름 오름차순
        return this.name.compareTo(o.name);
    }
}

public class 국영수 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Student[] students = new Student[N];

        StringTokenizer st = null;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            students[i] = new Student(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(students);

        for (Student s : students) {
            System.out.println(s.name);
        }


    }
}
