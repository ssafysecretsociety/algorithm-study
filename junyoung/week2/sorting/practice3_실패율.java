package junyoung.week2.sorting;

import java.util.ArrayList;
import java.util.Collections;

class practice3_실패율 {
    
    static class Rate{
        int idx;
        double rate;

        public Rate(int idx, double rate) {
            this.idx = idx;
            this.rate = rate;
        }
    }
    
    public static int[] solution(int N, int[] stages) {

        int[] user_cnt = new int[N+2];	
        int[] user_total_cnt = new int[N+1];

        for (int i = 0; i < stages.length; i++) {
            user_cnt[stages[i]]++;
        }

        user_total_cnt[N] = user_cnt[N] + user_cnt[N + 1]; 
        for (int i = N-1; i >= 1; i--) {
            user_total_cnt[i] = user_cnt[i] + user_total_cnt[i + 1];
        }

        ArrayList<Rate> arr = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            
            if(user_total_cnt[i]==0) {
                arr.add(new Rate(i, 0));
                continue;
            }
            
            double rate = (double) user_cnt[i] / user_total_cnt[i];
            arr.add(new Rate(i, rate));
        }

        Collections.sort(arr, ((o1, o2) -> Double.compare(o2.rate, o1.rate)));

        int[] answer = new int[N];
        for (int i=0; i<arr.size(); i++) {
            answer[i] = arr.get(i).idx;
        }
        
        return answer;
    }
}