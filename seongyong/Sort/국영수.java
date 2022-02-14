// https://www.acmicpc.net/problem/10825

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Student2 implements Comparable<Student2> {
    String name;
    int kor;
    int eng;
    int math;

    public Student2(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    @Override
    public int compareTo(Student2 o) {
        if (this.kor > o.kor)
            return -1;
        else if (this.kor == o.kor) {
            if (this.eng > o.eng)
                return 1;
            else if (this.eng == o.eng) {
                if (this.math > o.math)
                    return -1;
                else if (this.math == o.math) {
                    return this.name.compareTo(o.name);
                } else
                    return 1;
            } else
                return -1;
        } else {
            return 1;
        }
    }
}

public class 국영수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Student2> students = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            students.add(new Student2(st.nextToken(),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())));

        }
        Collections.sort(students);

        for(Student2 s: students)
            System.out.println(s.name);
    }
}
