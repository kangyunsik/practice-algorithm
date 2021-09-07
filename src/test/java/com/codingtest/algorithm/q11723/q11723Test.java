package com.codingtest.algorithm.q11723;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class q11723Test {
    String string =
            "add 1\n" +
            "add 2\n" +
            "check 1\n" +
            "check 2\n" +
            "check 3\n" +
            "remove 2\n" +
            "check 1\n" +
            "check 2\n" +
            "toggle 3\n" +
            "check 1\n" +
            "check 2\n" +
            "check 3\n" +
            "check 4\n" +
            "all\n" +
            "check 10\n" +
            "check 20\n" +
            "toggle 10\n" +
            "remove 20\n" +
            "check 10\n" +
            "check 20\n" +
            "empty\n" +
            "check 1\n" +
            "toggle 1\n" +
            "check 1\n" +
            "toggle 1\n" +
            "check 1\n";

    int[] answer = new int[]{1,1,0,
            1,0,1,
            0,1,0,
            1,1,0,
            0,0,1,0};
    
    @Test
    @DisplayName("예제 테스트")
    void pr_Test(){
        Main main = new Main();
        main.init(26);
        for(String string : string.split("\n"))
            main.run(string);
        assertThat(main.answer).isEqualTo((ArrayList<Integer>) Arrays.stream(answer).boxed().collect(Collectors.toList()));
    }

    @Test
    @DisplayName("최악의 경우")
    void pr_Test2(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3000000; i++) {
            sb.append("add "+(i%21)+"\n");
        }

        Main main = new Main();
        main.init(3000000);
        for(String string : sb.toString().split("\n"))
            main.run(string);
        assertThat(main.answer).isEqualTo(new ArrayList());
    }
}