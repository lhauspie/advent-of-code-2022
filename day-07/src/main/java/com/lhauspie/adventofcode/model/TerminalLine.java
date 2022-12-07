package com.lhauspie.adventofcode.model;

import com.lhauspie.adventofcode.model.command.ChangeDirectoryCommand;
import com.lhauspie.adventofcode.model.exception.InvalidChangeDirectoryCommandTerminalLineException;
import com.lhauspie.adventofcode.model.exception.InvalidDirectoryTerminalLineException;
import com.lhauspie.adventofcode.model.exception.InvalidFileTerminalLineException;
import com.lhauspie.adventofcode.model.filesystem.Directory;
import com.lhauspie.adventofcode.model.filesystem.File;

public class TerminalLine {
    private String value;

    public TerminalLine(String value) {
        this.value = value;
    }

    public static TerminalLine of(String value) {
        return new TerminalLine(value);
    }

    public boolean isCommand() {
        return value.startsWith("$ ");
    }

    public boolean isListCommand() {
        return value.startsWith("$ ls");
    }

    public boolean isChangeDirectoryCommand() {
        return value.startsWith("$ cd");
    }

    public boolean isDirectory() {
        return value.startsWith("dir ");
    }

    public boolean isFile() {
        return !isCommand() && !isDirectory();
    }

    public ChangeDirectoryCommand asChangeDirectoryCommand() {
        if (!isChangeDirectoryCommand()) {
            throw new InvalidChangeDirectoryCommandTerminalLineException();
        }
        return new ChangeDirectoryCommand(Name.of(value.split(" ")[2]));
    }

    public Directory asDirectory() {
        if (!isDirectory()) {
            throw new InvalidDirectoryTerminalLineException();
        }
        String[] splitValue = value.split(" ");
        return new Directory(Name.of(splitValue[1]));
    }

    public File asFile() {
        if (!isFile()) {
            throw new InvalidFileTerminalLineException();
        }
        String[] splitValue = value.split(" ");
        return new File(Size.of(Integer.parseInt(splitValue[0])));
    }
}
