package com.codingtest.algorithm.kakao.q1;

import java.util.*;

public class Solution {
    Map<String, ArrayList<String>> relation;
    Map<String, Integer> how;
    Set<String> sin;

    public int[] solution(String[] id_list, String[] report, int k) {
        relation = new HashMap<>();
        how = new HashMap<>();
        sin = new HashSet<>();

        for (int i = 0; i < id_list.length; i++) {
            relation.put(id_list[i], new ArrayList<>());
            how.put(id_list[i], 0);
        }

        for (String re : report) {
            StringTokenizer st = new StringTokenizer(re, " ");
            String id = st.nextToken();
            String target = st.nextToken();

            if(!relation.get(id).contains(target)) {
                relation.get(id).add(target);
                how.put(target, how.get(target) + 1);
            }
        }

        for (String s : how.keySet()) {
            if (k <= how.get(s)) {
                sin.add(s);
            }
        }

        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            int count = 0;
            for (String s : sin) {
                if (relation.get(id_list[i]).contains(s))
                    count++;
            }
            answer[i] = count;
        }


        return answer;
    }
}
