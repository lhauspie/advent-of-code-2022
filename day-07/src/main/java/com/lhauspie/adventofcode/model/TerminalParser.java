package com.lhauspie.adventofcode.model;

import com.lhauspie.adventofcode.model.filesystem.Directory;

import java.util.Scanner;

public class TerminalParser {

    public static Directory parse(Scanner scanner) {
        Directory currentDirectory = null;
        TerminalLine firstTerminalLine = TerminalLine.of(scanner.nextLine());
        if (firstTerminalLine.isChangeDirectoryCommand()) {
            currentDirectory = new Directory(firstTerminalLine.asChangeDirectoryCommand().getDirectoryName());
        }

        while (scanner.hasNextLine()) {
            currentDirectory = interpretTerminalLineInCurrentDirectory(TerminalLine.of(scanner.nextLine()), currentDirectory);
        }

        return currentDirectory.cd(Name.of("/"));
    }

    private static Directory interpretTerminalLineInCurrentDirectory(TerminalLine terminalLine, Directory currentDirectory) {
        if (terminalLine.isChangeDirectoryCommand()) {
            return currentDirectory.cd(terminalLine.asChangeDirectoryCommand().getDirectoryName());
        }
        if (terminalLine.isDirectory()) {
            currentDirectory.add(terminalLine.asDirectory());
        }
        if (terminalLine.isFile()) {
            currentDirectory.add(terminalLine.asFile());
        }
        return currentDirectory;
    }
}