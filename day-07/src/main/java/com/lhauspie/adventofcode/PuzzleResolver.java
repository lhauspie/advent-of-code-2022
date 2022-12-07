package com.lhauspie.adventofcode;

import com.lhauspie.adventofcode.model.Size;
import com.lhauspie.adventofcode.model.TerminalParser;
import com.lhauspie.adventofcode.model.filesystem.Directory;

import java.util.Comparator;
import java.util.Scanner;

public class PuzzleResolver {

    public static final Size FILE_SYSTEM_SIZE = Size.of(70000000);
    public static final Size UPDATE_SIZE = Size.of(30000000);

    public static Size resolveFirstPuzzle(Scanner scanner) {
        Directory rootDirectory = TerminalParser.parse(scanner);
        return rootDirectory.getDirectoriesWithTotalSizeOfAtMost(Size.of(100000))
                .stream().map(directory -> directory.getSize())
                .reduce((size, size2) -> size.sum(size2))
                .get();
    }


    public static Size resolveSecondPuzzle(Scanner scanner) {
        Directory rootDirectory = TerminalParser.parse(scanner);
        Size usedSpace = rootDirectory.getSize();
        Size freeSpace = FILE_SYSTEM_SIZE.sub(usedSpace);
        Size spaceToFreeUp = UPDATE_SIZE.sub(freeSpace);

        return rootDirectory.getDirectoriesWithTotalSizeOfAtLeast(spaceToFreeUp)
                .stream().map(directory -> directory.getSize())
                .min(Comparator.comparingInt(Size::getValue))
                .get();
    }
}
