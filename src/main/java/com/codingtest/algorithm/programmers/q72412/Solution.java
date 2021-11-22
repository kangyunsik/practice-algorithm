package com.codingtest.algorithm.programmers.q72412;

import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        List<Integer>[][][][] type = new ArrayList[3][2][2][2]; // cpp, java, python // be, fe // j, s // chick, pizza
        int[] answer = new int[query.length];

        ArrayList<Integer> a = new ArrayList<>();

        for (String s : info) {
            String[] detail = s.split(" ");
            int lang = 0;
            int work = 0;
            int year = 0;
            int food = 0;
            if (detail[0].equals("java")) lang = 1;
            if (detail[0].equals("python")) lang = 2;
            if (detail[1].equals("frontend")) work = 1;
            if (detail[2].equals("senior")) year = 1;
            if (detail[3].equals("pizza")) food = 1;
            if (type[lang][work][year][food] == null)
                type[lang][work][year][food] = new ArrayList<>();
            int score = Integer.parseInt(detail[4]);
            type[lang][work][year][food].add(score);
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    for (int l = 0; l < 2; l++) {
                        if (type[i][j][k][l] != null) {
                            Collections.sort(type[i][j][k][l]);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < query.length; i++) {
            String[] q = query[i].split(" ");
            int lang_s = 0, lang_e = 0;
            int work_s = 0, work_e = 0;
            int year_s = 0, year_e = 0;
            int food_s = 0, food_e = 0;
            if (q[0].equals("java")) lang_s = lang_e = 1;
            if (q[0].equals("python")) lang_s = lang_e = 2;
            if (q[0].equals("-")) lang_e = 2;
            if (q[2].equals("frontend")) work_s = work_e = 1;
            if (q[2].equals("-")) work_e = 1;
            if (q[4].equals("senior")) year_s = year_e = 1;
            if (q[4].equals("-")) year_e = 1;
            if (q[6].equals("pizza")) food_s = food_e = 1;
            if (q[6].equals("-")) food_e = 1;

            int opt = Integer.parseInt(q[7]);
            int count = 0;
            for (int j = lang_s; j <= lang_e; j++) {
                for (int k = work_s; k <= work_e; k++) {
                    for (int l = year_s; l <= year_e; l++) {
                        for (int m = food_s; m <= food_e; m++) {
                            if (type[j][k][l][m] != null) {
                                int locate = Collections.binarySearch(type[j][k][l][m], opt);
                                if (locate < 0) {
                                    count += type[j][k][l][m].size() + (locate + 1);
                                } else {
                                    while (locate > 0 && type[j][k][l][m].get(locate - 1) == opt) {
                                        locate--;
                                    }
                                    count += type[j][k][l][m].size() - locate;
                                }
                            }

                        }
                    }
                }
            }
            answer[i] = count;
        }
        return answer;
    }
}