package com.codingtest.algorithm.kakao.q3;

import java.util.*;

public class Solution {
    Map<String, Integer> in_time;
    Map<String, Integer> cost;
    int def;
    int defc;
    int vt;
    int vc;


    public int[] solution(int[] fees, String[] records) {
        in_time = new HashMap<>();
        cost = new HashMap<>();
        def = fees[0];
        defc = fees[1];
        vt = fees[2];
        vc = fees[3];

        for (String record : records) {
            StringTokenizer st = new StringTokenizer(record, " ");
            String time = st.nextToken();
            String number = st.nextToken();
            String option = st.nextToken();

            if (option.equals("IN")) {
                in_time.put(number, toMinute(time));
                if (cost.get(number) == null) {
                    cost.put(number, toMinute(time) - in_time.get(number));
                }
            } else {

                cost.put(number, toMinute(time) - in_time.get(number) + cost.get(number));

                in_time.remove(number);
            }
        }

        for (String s : in_time.keySet())
            cost.put(s, toMinute("23:59") - in_time.get(s) + cost.get(s));

        ArrayList<Car> cars = new ArrayList<Car>();
        for (String s : cost.keySet()) {
            cars.add(new Car(Integer.parseInt(s), calcCostByMin(cost.get(s))));
        }

        Collections.sort(cars);
        int[] answer = new int[cars.size()];
        for (int i = 0; i < cars.size(); i++) {
            answer[i] = cars.get(i).cost;
        }

        return answer;
    }

    class Car implements Comparable<Car> {
        int number;
        int cost;

        public Car(int number, int cost) {
            this.number = number;
            this.cost = cost;
        }

        @Override
        public int compareTo(Car o) {
            return this.number >= o.number ? 1 : -1;
        }
    }

    private int calcCostByMin(int i) {
        if (i <= def) {
            return defc;
        } else {
            int k = (i - def + vt - 1) / vt;
            return defc + k * vc;
        }
    }

    private Integer toMinute(String time) {
        StringTokenizer st = new StringTokenizer(time, ":");
        return Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
    }
}
