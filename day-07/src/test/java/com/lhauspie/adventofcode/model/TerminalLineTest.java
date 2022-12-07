package com.lhauspie.adventofcode.model;

import com.lhauspie.adventofcode.model.exception.InvalidChangeDirectoryCommandTerminalLineException;
import com.lhauspie.adventofcode.model.exception.InvalidDirectoryTerminalLineException;
import com.lhauspie.adventofcode.model.exception.InvalidFileTerminalLineException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TerminalLineTest {

    @Test
    public void thisTerminalLineIsChangeDirectoryCommand() {
        assertTrue(TerminalLine.of("$ cd toto").isChangeDirectoryCommand());
    }

    @Test
    public void thisTerminalLineIsNotListCommand1() {
        assertFalse(TerminalLine.of("$ cd toto").isListCommand());
    }

    @Test
    public void thisTerminalLineIsNotDirectory1() {
        assertFalse(TerminalLine.of("$ cd toto").isDirectory());
    }

    @Test
    public void thisTerminalLineIsNotFile1() {
        assertFalse(TerminalLine.of("$ cd toto").isFile());
    }

    @Test
    public void thisTerminalLineIsListCommand() {
        assertTrue(TerminalLine.of("$ ls").isListCommand());
    }

    @Test
    public void thisTerminalLineIsNotChangeDirectoryCommand2() {
        assertFalse(TerminalLine.of("$ ls").isChangeDirectoryCommand());
    }

    @Test
    public void thisTerminalLineIsNotDirectory2() {
        assertFalse(TerminalLine.of("$ ls").isDirectory());
    }

    @Test
    public void thisTerminalLineIsNotFile2() {
        assertFalse(TerminalLine.of("$ ls").isFile());
    }

    @Test
    public void thisTerminalLineIsDirectory() {
        assertTrue(TerminalLine.of("dir zuyetze").isDirectory());
    }

    @Test
    public void thisTerminalLineIsNotFile3() {
        assertFalse(TerminalLine.of("dir zuyetze").isFile());
    }

    @Test
    public void thisTerminalLineIsChangeDirectoryCommand3() {
        assertFalse(TerminalLine.of("dir zuyetze").isChangeDirectoryCommand());
    }

    @Test
    public void thisTerminalLineIsListCommand3() {
        assertFalse(TerminalLine.of("dir zuyetze").isListCommand());
    }

    @Test
    public void thisTerminalLineIsFile() {
        assertTrue(TerminalLine.of("8976764 file.txt").isFile());
    }

    @Test
    public void thisTerminalLineIsNotDirectory4() {
        assertFalse(TerminalLine.of("8976764 file.txt").isDirectory());
    }

    @Test
    public void thisTerminalLineIsNotChangeDirectoryCommand4() {
        assertFalse(TerminalLine.of("8976764 file.txt").isChangeDirectoryCommand());
    }

    @Test
    public void thisTerminalLineIsNotListCommand4() {
        assertFalse(TerminalLine.of("8976764 file.txt").isListCommand());
    }

    @Test
    public void canParseDirectoryFromDirectoryTerminalLine() {
        TerminalLine terminalLine = TerminalLine.of("dir a");
        assertDoesNotThrow(() -> terminalLine.asDirectory());
    }

    @Test
    public void cantParseDirectoryFromFileTerminalLine() {
        TerminalLine terminalLine = TerminalLine.of("23456 b");
        assertThrows(InvalidDirectoryTerminalLineException.class, () -> terminalLine.asDirectory());
    }

    @Test
    public void canParseFileFromFileTerminalLine() {
        TerminalLine terminalLine = TerminalLine.of("34567 b.dsds");
        assertDoesNotThrow(() -> terminalLine.asFile());
    }

    @Test
    public void cantParseFileFromDirectoryTerminalLine() {
        TerminalLine terminalLine = TerminalLine.of("dir aze");
        assertThrows(InvalidFileTerminalLineException.class, () -> terminalLine.asFile());
    }

    @Test
    public void canParseChangeDirectoryCommandFromChangeDirectoryCommandTerminalLine() {
        TerminalLine terminalLine = TerminalLine.of("$ cd toto");
        assertEquals(Name.of("toto"), terminalLine.asChangeDirectoryCommand().getDirectoryName());
    }

    @Test
    public void cantParseChangeDirectoryCommandFromFileTerminalLine() {
        TerminalLine terminalLine = TerminalLine.of("34567 b.dsds");
        assertThrows(InvalidChangeDirectoryCommandTerminalLineException.class, () -> terminalLine.asChangeDirectoryCommand());
    }
}