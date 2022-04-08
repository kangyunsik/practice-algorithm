package com.codingtest.algorithm.acmicpc.q21941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static Map<String, Integer> dpMapper = new HashMap<>();
    static Map<String, Integer> valueMapper = new HashMap<>();
    static String[] starCache = new String[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String origin = br.readLine();
        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 100; i++) {
            sb.append("*");
            starCache[i] = sb.toString();
        }

        String input;
        int value;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            input = st.nextToken();
            value = Integer.parseInt(st.nextToken());
            valueMapper.put(input, Math.max(valueMapper.getOrDefault(input, 0), value));
        }
        int ans = findMaxValue(origin, 0);
        System.out.println(ans);
    }

    private static int findMaxValue(String string, int starCnt) {
        if (dpMapper.containsKey(string)) return dpMapper.get(string);
        int ret = string.length() - starCnt;
        for (String s : valueMapper.keySet()) {
            if (string.contains(s)) {
                String stars = starCache[s.length()];
                String replace = string.replaceAll(s, stars);
                int after = getStarCnt(replace);
                int cnt = (after - starCnt) / s.length();
                ret = Math.max(ret, findMaxValue(replace, after) + cnt * valueMapper.get(s));
            }
        }
        dpMapper.put(string, ret);
        return ret;
    }

    private static int getStarCnt(String string) {
        int cnt = 0;
        for (int i = 0, len = string.length(); i < len; i++) {
            if (string.charAt(i) == '*') cnt++;
        }
        return cnt;
    }
}
