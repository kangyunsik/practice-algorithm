package com.codingtest.algorithm.programmers.q17676;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(String[] lines) {
        List<Time> list = new ArrayList<>();
        int answer = 0;

        for (String line : lines) {
            String time = line.split(" ")[1];
            String consume = line.split(" ")[2];
            list.add(new Time(time, consume));
        }

        for (int i = 0; i < lines.length; i++) {
            int endTime = list.get(i).end;
            int count = 0;

            for (int j = 0; j < lines.length; j++) {
                int n_startTime = list.get(j).start;
                int n_endTime = list.get(j).end;
                if (!(endTime + 1000 <= n_startTime || endTime > n_endTime)) {
                    count++;
                }
            }
            answer = Math.max(count, answer);
        }

        return answer;
    }

    class Time {
        int start;
        int end;

        public Time(String time, String consume) {
            int temp = 0;
            for (String s : time.split("\\.")[0].split(":")) {
                temp += Integer.parseInt(s);
                temp *= 60;
            }
            temp /= 60;
            temp *= 1000;

            temp += Integer.parseInt(time.split("\\.")[1]);
            this.end = temp;

            double d = Double.parseDouble(consume.replace("s", ""));
            d *= 1000;
            this.start = this.end - (int) d + 1;
        }
    }
}