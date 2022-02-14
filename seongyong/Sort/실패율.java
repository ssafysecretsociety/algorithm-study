// https://programmers.co.kr/learn/courses/30/lessons/42889

import java.util.Arrays;


class Stage implements Comparable<Stage>{
    int No;
    int stageNum;
    int people;
    double failRate;

    public Stage(int No) {
        this.stageNum = 0;
        this.people = 0;
        this.failRate = 0.0;
        this.No = No;
    }

    public void calcFailRate(){
        if(people == 0)
            failRate = 0.0;
        else
            this.failRate = (double)stageNum/(double)people;
    }


    @Override
    public int compareTo(Stage o) {
        if(this.failRate > o.failRate)
            return -1;
        else if(this.failRate == o.failRate){
            if(this.No > o.No)
                return 1;
        }
        return 0;
    }
}

public class 실패율 {
    public static int[] solution(int N, int[] stages) {
        Stage[] stage = new Stage[N];

        for (int i = 0; i < N; i++) {
            stage[i] = new Stage(i+1);
        }


        for (int i = 0; i < stage.length; i++) {
            int people = 0;
            int stageNum = 0;
            for (int j = 0; j < stages.length; j++) {
                if(stages[j]-1 == i)
                    stageNum++;
                if(stages[j]-1 >=i)
                    people++;
            }
            stage[i].people = people;
            stage[i].stageNum = stageNum;
            stage[i].calcFailRate();
        }


        Arrays.sort(stage);
        int[] result = new int[N];
        for (int i = 0; i < stage.length; i++)
            result[i] = stage[i].No;

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5,new int[]{2,1,2,6,2,4,3,3})));
//        System.out.println(Arrays.toString(solution(4,new int[]{4,4,4,4})));
    }
}
