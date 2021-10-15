package com.codingtest.algorithm.acmicpc.q17219;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class q17219Test {
    String[] strings = ("noj.am IU\n" +
            "acmicpc.net UAENA\n" +
            "startlink.io THEKINGOD\n" +
            "google.com ZEZE\n" +
            "nate.com VOICEMAIL\n" +
            "naver.com REDQUEEN\n" +
            "daum.net MODERNTIMES\n" +
            "utube.com BLACKOUT\n" +
            "zum.com LASTFANTASY\n" +
            "dreamwiz.com RAINDROP\n" +
            "hanyang.ac.kr SOMEDAY\n" +
            "dhlottery.co.kr BOO\n" +
            "duksoo.hs.kr HAVANA\n" +
            "hanyang-u.ms.kr OBLIVIATE\n" +
            "yd.es.kr LOVEATTACK\n" +
            "mcc.hanyang.ac.kr ADREAMER").split("\n");

    String [] runnable = ("startlink.io\n" +
            "acmicpc.net\n" +
            "noj.am\n" +
            "mcc.hanyang.ac.kr").split("\n");

    @Test
    void test(){
        String[] answer = ("THEKINGOD\n" +
                "UAENA\n" +
                "IU\n" +
                "ADREAMER").split("\n");
        Main main = new Main();
        main.init(4);

        for (String string : strings) {
            main.set(string);
        }
        for (String s : runnable) {
            main.run(s);
        }

        assertThat(main.getAnswer()).isEqualTo(answer);

    }
}