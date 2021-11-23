package com.codingtest.algorithm.programmers.q77486;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        Map<String, Node> employee = new HashMap<>();
        employee.put("-",new Node("-"));
        for (String s : enroll) {
            employee.put(s, new Node(s));
        }

        for (int i = 0; i < referral.length; i++) {
            employee.get(enroll[i]).setReferral(employee.get(referral[i]));
        }

        for (int i = 0; i < seller.length; i++) {
            employee.get(seller[i]).earnMoney(amount[i] * 100);
        }


        for (int i = 0; i < enroll.length; i++) {
            answer[i] = employee.get(enroll[i]).value;
        }
        return answer;
    }

    class Node{
        String name;
        Node referral;
        int value;

        public Node(String name) {
            this.name = name;
            this.value = 0;
        }

        public void setReferral(Node referral) {
            this.referral = referral;
        }

        public void earnMoney(int money){
            if(money >= 10 || referral != null){
                this.referral.earnMoney(money/10);
                this.value += money - money/10;
            }else{
                this.value += money;
            }
        }
    }
}