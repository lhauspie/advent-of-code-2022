package com.lhauspie.adventofcode.model.filesystem;

import com.lhauspie.adventofcode.model.Name;
import com.lhauspie.adventofcode.model.Size;

import java.util.*;

public class Directory {

    private static Name ROOT_DIRECTORY_NAME = Name.of("/");
    private static Name PARENT_DIRECTORY_NAME = Name.of("..");

    private final Name name;
    private Directory parentDirectory;
    private List<File> files = new ArrayList<>();
    private Map<Name, Directory> subDirectories = new HashMap<>();

    public Directory(Name name) {
        this.name = name;
    }

    public Size getSize() {
        Size filesSize = files.stream().map(file -> file.getSize())
                .reduce((size, size2) -> size.sum(size2))
                .orElse(Size.of(0));
        Size subDirsSize = subDirectories.values().stream().map(dir -> dir.getSize())
                .reduce((size, size2) -> size.sum(size2))
                .orElse(Size.of(0));
        return filesSize.sum(subDirsSize);
    }

    public Name getName() {
        return name;
    }

    public void add(File file) {
        files.add(file);
    }

    public void add(Directory directory) {
        directory.parentDirectory = this;
        subDirectories.put(directory.getName(), directory);
    }

    public Directory cd(Name name) {
        if (ROOT_DIRECTORY_NAME.equals(name)) {
            if (this.isRoot()) {
                return this;
            } else {
                return parentDirectory.cd(name);
            }
        }

        if (PARENT_DIRECTORY_NAME.equals(name)) {
            if (this.isRoot()) {
                return this;
            }
            return parentDirectory;
        }

        if (subDirectories.containsKey(name)) {
            return subDirectories.get(name);
        }

        throw new DirectoryNotFoundException();
    }

    private boolean isRoot() {
        return parentDirectory == null;
    }

    public List<Directory> getDirectoriesWithTotalSizeOfAtMost(Size maxSize) {
        List<Directory> directories = new ArrayList<>();
        for (Directory d : subDirectories.values()) {
            if (d.getSize().lessOrEqualsThan(maxSize)) {
                directories.add(d);
            }
            directories.addAll(d.getDirectoriesWithTotalSizeOfAtMost(maxSize));
        }
        return directories;
    }

    @Override
    public String toString() {
        return name + " (dir)";
    }

    public List<Directory> getDirectoriesWithTotalSizeOfAtLeast(Size minSize) {
        List<Directory> directories = new ArrayList<>();
        for (Directory d : subDirectories.values()) {
            if (minSize.lessOrEqualsThan(d.getSize())) {
                directories.add(d);
            }
            directories.addAll(d.getDirectoriesWithTotalSizeOfAtLeast(minSize));
        }
        return directories;
    }
}
