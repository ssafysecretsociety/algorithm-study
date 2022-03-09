// 2022 kakao blind recruitment
// https://programmers.co.kr/learn/courses/30/lessons/92334

package 프로그래머스.level1;

import java.util.*;

public class 신고결과받기 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new 신고결과받기().solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}, 2)));
    }

    public int[] solution(String[] id_list, String[] report, int k) {
        int length = id_list.length;

        // 유저 닉네임을 index로 변환해줄 map 선언
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            map.put(id_list[i], i);
        }

        // 중복 신고 방지를 위해 set 자료형으로 배열 선언
        Set<String>[] sets = new HashSet[length];
        for (int i = 0; i < length; i++) {
            sets[i] = new HashSet<>();
        }

        int[] counts = new int[length]; // 유저가 신고당한 횟수를 저장할 배열

        // 각각의 신고 건에 대하여
        for (String oneReport : report) {
            StringTokenizer st = new StringTokenizer(oneReport);
            String from = st.nextToken();
            String to = st.nextToken();

            Set now = sets[map.get(from)];
            // 만약, set에 신고한 유저가 없다면
            // set에 신고한 유저 추가, 신고당한 유저의 카운트 증가
            if (!now.contains(to)) {
                now.add(to);
                counts[map.get(to)]++;
            }
        }

        int[] result = new int[length]; // 메일 전송받을 횟수를 저장할 배열

        // 유저 한 명씩 탐색
        for (int i = 0; i < length; i++) {
            // 해당 유저가 기준 신고건을 넘어섰을 때
            if (counts[i] >= k) {
                // set을 하나씩 탐색하며, 유저를 포함하고 있을 시 메일 보내는 카운트 증가
                for (int j = 0; j < length; j++) {
                    if (sets[j].contains(id_list[i])) {
                        result[j]++;
                    }
                }
            }
        }

        return result;
    }
}
