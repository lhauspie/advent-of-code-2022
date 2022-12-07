package com.lhauspie.adventofcode.model.command;

import com.lhauspie.adventofcode.model.Name;

public class ChangeDirectoryCommand {
    private Name directoryName;

    public ChangeDirectoryCommand(Name directoryName) {
        this.directoryName = directoryName;
    }

    public Name getDirectoryName() {
        return directoryName;
    }
}
