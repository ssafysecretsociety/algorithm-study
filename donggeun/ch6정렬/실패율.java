package ch6정렬;

import java.util.Arrays;

public class 실패율 {
    public static void main(String[] args) {
//        System.out.println(new 실패율().solution());
        System.out.println(Arrays.toString(new 실패율().solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3})));
        System.out.println(Arrays.toString(new 실패율().solution(4, new int[]{4, 4, 4, 4, 4})));
    }

    public int[] solution(int N, int[] stages) {

        int[] arr = new int[N + 2];
        StageInfo[] stageInfos = new StageInfo[N];

        for (int i : stages) {
            arr[i] += 1;
        }

        // 스테이지를 통과할 때마다, 실패한 인원을 현재 인원수로 나누어 저장
        // 현재 스테이지에서 실패한 사람들의 수를 현재 인원수에서 제거
        int player = stages.length;
        for (int i = 1; i <= N; i++) {
            double failRate = 0;
            if (arr[i] != 0) {
                failRate = (double) arr[i] / player;
            }
            stageInfos[i - 1] = new StageInfo(i, failRate);
            player -= arr[i];
        }

        Arrays.sort(stageInfos);

        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            result[i] = stageInfos[i].idx;
        }

        return result;


    }

    // Comparable 인터페이스를 구현한 StageInfo 클래스 선언
    class StageInfo implements Comparable<StageInfo> {
        int idx;
        double failRate;

        public StageInfo(int idx, double failRate) {
            this.idx = idx;
            this.failRate = failRate;
        }

        @Override
        public int compareTo(StageInfo o) {
            // 1차: 실패율 내림차순
            if (this.failRate != o.failRate) {
                return Double.compare(o.failRate, this.failRate);
            }

            // 2차: 스테이지 번호 오름차순
            return Integer.compare(this.idx, o.idx);
        }
    }
}
