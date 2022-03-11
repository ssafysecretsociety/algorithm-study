// 2019 KAKAO BLIND RECRUITMENT
// https://programmers.co.kr/learn/courses/30/lessons/42888

package 프로그래머스.level2;


import java.util.*;

public class 오픈채팅방 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new 오픈채팅방().solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"})));
    }

    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>(); // uid를 Key로 해 현재 닉네임을 value로 사용하는 Map
        List<String[]> logs = new ArrayList<>(); // 출력할 로그들이 저장될 List

        for (String line : record) {
            StringTokenizer st = new StringTokenizer(line);
            String cmd = st.nextToken();
            String uid = st.nextToken();
            if (st.hasMoreTokens()) {
                // cmd가 Enter, Change인 경우에는 Map 요소 조작
                String nickname = st.nextToken();
                if (map.containsKey(uid)) {
                    map.replace(uid, nickname);
                } else {
                    map.put(uid, nickname);
                }
            }

            if (cmd.equals("Enter")) {
                logs.add(new String[]{uid, "님이 들어왔습니다."});
            } else if (cmd.equals("Leave")) {
                logs.add(new String[]{uid, "님이 나갔습니다."});
            }
        }

        String[] result = new String[logs.size()];

        // 로그에 기록된 기록들에 대해 최종 닉네임을 기준으로 출력문 생성
        int i = 0;
        for (String[] log : logs) {
            StringBuilder sb = new StringBuilder();
            sb.append(map.get(log[0])).append(log[1]);
            result[i++] = sb.toString();
        }
        return result;
    }
}
