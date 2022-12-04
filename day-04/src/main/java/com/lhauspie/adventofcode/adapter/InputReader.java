package com.lhauspie.adventofcode.adapter;

import com.lhauspie.adventofcode.model.Pair;
import com.lhauspie.adventofcode.model.Range;

public class InputReader {

    public static Pair inputPairContentToPair(String pairContent) {
        String[] splitLine = pairContent.split(",");
        String[] firstIntStr = splitLine[0].split("-");
        String[] secondIntStr = splitLine[1].split("-");
        return new Pair(
                new Range(Integer.parseInt(firstIntStr[0]), Integer.parseInt(firstIntStr[1])),
                new Range(Integer.parseInt(secondIntStr[0]), Integer.parseInt(secondIntStr[1]))
        );
    }
}
