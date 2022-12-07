package com.lhauspie.adventofcode.model;

import com.lhauspie.adventofcode.model.filesystem.Directory;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TerminalParserTest {


    @Test
    public void inputExampleHasSize48381165() {
        String input = """
                    $ cd /
                    $ ls
                    dir a
                    14848514 b.txt
                    8504156 c.dat
                    dir d
                    $ cd a
                    $ ls
                    dir e
                    29116 f
                    2557 g
                    62596 h.lst
                    $ cd e
                    $ ls
                    584 i
                    $ cd ..
                    $ cd ..
                    $ cd d
                    $ ls
                    4060174 j
                    8033020 d.log
                    5626152 d.ext
                    7214296 k
                    """;
        Directory root = TerminalParser.parse(new Scanner(input));
        assertEquals(Size.of(48381165), root.getSize());
        assertEquals(Size.of(94853), root.cd(Name.of("a")).getSize());
        assertEquals(Size.of(24933642), root.cd(Name.of("d")).getSize());
    }
}
