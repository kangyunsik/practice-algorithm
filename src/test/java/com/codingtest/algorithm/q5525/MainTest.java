package com.codingtest.algorithm.q5525;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MainTest {

    @Test
    @DisplayName("예제 테스트1")
    void practice_Solution1(){
        Main main = new Main();
        main.init(1,13,"OOIOIOIOIIOII");
        main.run();
        assertThat(main.answer).isEqualTo(4);
    }

    @Test
    @DisplayName("예제 테스트1")
    void practice_Solution2(){
        Main main = new Main();
        main.init(2,13,"OOIOIOIOIIOII");
        main.run();
        assertThat(main.answer).isEqualTo(2);
    }
}
