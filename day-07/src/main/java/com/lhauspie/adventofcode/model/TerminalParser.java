package com.lhauspie.adventofcode.model;

import com.lhauspie.adventofcode.model.command.*;
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
            TerminalLine terminalLine = TerminalLine.of(scanner.nextLine());
            if (terminalLine.isChangeDirectoryCommand()) {
                currentDirectory = currentDirectory.cd(terminalLine.asChangeDirectoryCommand().getDirectoryName());
            }
            if (terminalLine.isDirectory()) {
                currentDirectory.add(terminalLine.asDirectory());
            }
            if (terminalLine.isFile()) {
                currentDirectory.add(terminalLine.asFile());
            }
        }

        return currentDirectory.cd(Name.of("/"));
    }
}