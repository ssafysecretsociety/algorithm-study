import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Student implements Comparable<Student>{
    int score;
    String name;

    public Student( String name, int score) {
        this.score = score;
        this.name = name;
    }

    @Override
    public int compareTo(Student o) {
        if(this.score > o.score)
            return 1;
        return -1;
    }
}

public class 성적이낮은순서로학생출력하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        ArrayList<Student> students = new ArrayList<>();

        for (int i = 0; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            students.add(new Student(st.nextToken(), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(students);

        for(Student s: students) {
            System.out.print(s.name +" ");
        }

    }
}
