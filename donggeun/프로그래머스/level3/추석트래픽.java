package 프로그래머스.level3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 추석트래픽 {

    public static void main(String[] args) {
        System.out.println(new 추석트래픽().solution(new String[]{"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"}));
    }

    public int solution(String[] lines) {

        Log[] logs = new Log[lines.length];
        int index = 0;

        for (String line : lines) {
            String[] splited = line.split(" ");
            String time = splited[1];
            String duration = splited[2];

            String[] timeSplited = time.split(":");
            int hour = Integer.parseInt(timeSplited[0]);
            int min = Integer.parseInt(timeSplited[1]);

            String[] secSplited = timeSplited[2].split("[.]");
            int sec = Integer.parseInt(secSplited[0]);
            int ms = Integer.parseInt(secSplited[1]);

            duration = duration.replace("s", "");
            int durationMs = (int) (Float.parseFloat(duration) * 1000);

            int endMs = getMillisecond(hour, min, sec, ms);
            int startMs = endMs - durationMs + 1;

            logs[index++] = new Log(startMs, endMs);
        }

        Arrays.sort(logs);

        index = 0;
        PriorityQueue<Log> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.end));

        int time = logs[0].start;
        int max = Integer.MIN_VALUE;
        while (index < lines.length) {
            while (logs[index].start < time + 1000) {
                pq.add(logs[index]);
                index++;
                if (index == lines.length) {
                    break;
                }
            }

            while (!pq.isEmpty() && pq.peek().end < time) {
                pq.poll();
            }

            max = Math.max(max, pq.size());
            time++;
        }


        return max;
    }

    private int getMillisecond(int hour, int min, int sec, int ms) {
        int result = ms;
        result += sec * 1000;
        result += min * 1000 * 60;
        result += hour * 1000 * 60 * 60;

        return result;
    }

    static class Log implements Comparable<Log> {
        int start;
        int end;

        public Log(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Log{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }

        @Override
        public int compareTo(Log o) {
            if (this.start != o.start) {
                return Integer.compare(this.start, o.start);
            }
            return Integer.compare(this.end, o.end);
        }
    }
}
