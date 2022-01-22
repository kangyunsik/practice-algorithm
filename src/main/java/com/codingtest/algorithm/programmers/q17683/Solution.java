package com.codingtest.algorithm.programmers.q17683;

import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        int ansLen = 0;
        String ans = "(None)";
        m = encode(m);

        for (String musicinfo : musicinfos) {
            StringTokenizer st = new StringTokenizer(musicinfo, ",");
            int min = subtract(st.nextToken(), st.nextToken());
            int time = min;
            String keyword = st.nextToken();
            String pat = encode(st.nextToken());
            StringBuilder sb = new StringBuilder();
            while (min >= pat.length()) {
                sb.append(pat);
                min -= pat.length();
            }
            sb.append(pat, 0, min);

            if(sb.toString().contains(m) && time > ansLen){
                ansLen = time;
                ans = keyword;
            }
        }

        return ans;
    }


    private String encode(String s){
        s = s.replaceAll("C#","c");
        s = s.replaceAll("D#","d");
        s = s.replaceAll("F#","f");
        s = s.replaceAll("G#","g");
        s = s.replaceAll("A#","a");
        return s;
    }

    private int subtract(String s1, String s2) {
        int[] time1 = {Integer.parseInt(s1.substring(0,2)), Integer.parseInt(s1.substring(3))};
        int[] time2 = {Integer.parseInt(s2.substring(0,2)), Integer.parseInt(s2.substring(3))};
        return time2[0] * 60 + time2[1] - time1[0] * 60 - time1[1];
    }
}