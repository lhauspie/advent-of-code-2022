package com.lhauspie.adventofcode;

import com.lhauspie.adventofcode.adapter.InputReader;
import com.lhauspie.adventofcode.model.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InputReaderTest {

    @Test
    public void test1() {
        Pair pair = InputReader.inputPairContentToPair("10-30,20-50");
        Assertions.assertEquals(10, pair.left().start());
        Assertions.assertEquals(30, pair.left().stop());
        Assertions.assertEquals(20, pair.right().start());
        Assertions.assertEquals(50, pair.right().stop());
    }
}
