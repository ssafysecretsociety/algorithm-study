package junyoung.week2.sorting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class practice1_국영수 {
	
	static int N;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        Student[] students = new Student[N];

        for (int i = 0; i < N; i++) {
            String[] score = br.readLine().split(" ");
            students[i] = new Student(
                    score[0],
                    Integer.parseInt(score[1]),
                    Integer.parseInt(score[2]),
                    Integer.parseInt(score[3]));
        }
        
        Comparator<Student> comparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.korean < o2.korean) {
                    return 1;
                }else if(o1.korean == o2.korean) {
                    if(o1.english > o2.english) {
                        return 1;
                    }else if(o1.english == o2.english) {
                        if(o1.math < o2.math) {
                            return 1;
                        }else if (o1.math == o2.math) {
                            return o1.name.compareTo(o2.name);
                        }
                    }
                }
                return -1;
            }
        };
        Arrays.sort(students, comparator);
        for (int i = 0; i < N; i++) {
            bw.write(students[i].name + "\n");
        }

        bw.flush();
        bw.close();
    }
}

class Student {
    String name;
    int korean;
    int english;
    int math;

    Student(String name, int korean, int english, int math) {
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
    }
}