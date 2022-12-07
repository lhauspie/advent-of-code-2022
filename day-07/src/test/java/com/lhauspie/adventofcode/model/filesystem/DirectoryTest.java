package com.lhauspie.adventofcode.model.filesystem;

import com.lhauspie.adventofcode.model.Name;
import com.lhauspie.adventofcode.model.Size;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class DirectoryTest {

    @Test
    public void newDirectoryHasSizeEqualsToZero() {
        Directory directory = new Directory(Name.of("/"));
        assertEquals(Size.of(0), directory.getSize());
    }

    @Test
    public void addingSubDirectoryToDirectoryHasSizeEqualsToZero() {
        Directory directory = new Directory(Name.of("/"));
        directory.add(new Directory(Name.of("a")));
        assertEquals(Size.of(0), directory.getSize());
    }

    @Test
    public void addingFileToDirectoryHasSizeEqualsToFileSizeTwenty() {
        Directory directory = new Directory(Name.of("/"));
        directory.add(new File(Size.of(20)));
        assertEquals(Size.of(20), directory.getSize());
    }

    @Test
    public void addingTwoFilesToDirectoryHasSizeEqualsToSumOfFilesSizes() {
        Directory directory = new Directory(Name.of("/"));
        directory.add(new File(Size.of(20)));
        directory.add(new File(Size.of(20)));
        assertEquals(Size.of(40), directory.getSize());
    }

    @Test
    public void addingTwoFilesToSubDirectoryInDirectoryHasSizeEqualsToSumOfFilesSizes() {
        Directory directory = new Directory(Name.of("/"));
        Directory subDirectory = new Directory(Name.of("a"));
        directory.add(subDirectory);
        subDirectory.add(new File(Size.of(20)));
        subDirectory.add(new File(Size.of(20)));
        assertEquals(Size.of(40), directory.getSize());
    }

    @Test
    public void addingTwoFilesToTwoSubDirectoriesInDirectoryHasSizeEqualsToSumOfFilesSizes() {
        Directory directory = new Directory(Name.of("/"));
        Directory subDirectory1 = new Directory(Name.of("a"));
        Directory subDirectory2 = new Directory(Name.of("b"));
        directory.add(subDirectory1);
        directory.add(subDirectory2);
        subDirectory1.add(new File(Size.of(20)));
        subDirectory2.add(new File(Size.of(20)));
        assertEquals(Size.of(40), directory.getSize());
    }

    @Test
    public void navigationInSubDirectoryIsPossible() {
        Directory root = new Directory(Name.of("/"));
        Directory aDirectory = new Directory(Name.of("a"));
        root.add(aDirectory);

        assertEquals(aDirectory, root.cd(Name.of("a")));
    }

    @Test
    public void navigationOutToParentDirectoryIsPossible() {
        Directory root = new Directory(Name.of("/"));
        Directory aDirectory = new Directory(Name.of("a"));
        root.add(aDirectory);

        assertEquals(root, root.cd(Name.of("a")).cd(Name.of("..")));
    }

    @Test
    public void navigationOutToParentDirectoryIsPossibleEvenIfItsRootDirectory() {
        Directory root = new Directory(Name.of("/"));
        Directory aDirectory = new Directory(Name.of("a"));
        root.add(aDirectory);

        assertEquals(root, root.cd(Name.of("..")));
    }

    @Test
    public void navigationInUnknownSubDirectoryIsNotPossible() {
        Directory root = new Directory(Name.of("/"));

        assertThrows(DirectoryNotFoundException.class, () -> root.cd(Name.of("a")));
    }

    @Test
    public void navigationOutToRootDirectoryIsPossible() {
        Directory root = new Directory(Name.of("/"));
        Directory aDirectory = new Directory(Name.of("a"));
        Directory bDirectory = new Directory(Name.of("b"));
        root.add(aDirectory);
        aDirectory.add(bDirectory);

        assertEquals(root, root.cd(Name.of("a")).cd(Name.of("b")).cd(Name.of("/")));
    }

    @Test
    public void navigationOutToRootDirectoryIsPossibleEvenOnRootDirectory() {
        Directory root = new Directory(Name.of("/"));
        assertEquals(root, root.cd(Name.of("/")));
    }

    @Test
    public void getDirectoriesWithTotalSizeOfAtMostShouldReturnAE() {
        Directory root = new Directory(Name.of("/"));
        root.add(new Directory(Name.of("a")));
        root.add(new Directory(Name.of("d")));
        root.cd(Name.of("a")).add(new Directory(Name.of("e")));
        root.cd(Name.of("a")).cd(Name.of("e")).add(new File(Size.of(584)));
        root.cd(Name.of("a")).add(new File(Size.of(29116)));
        root.cd(Name.of("a")).add(new File(Size.of(2557)));
        root.cd(Name.of("a")).add(new File(Size.of(62596)));
        root.add(new File(Size.of(14848514)));
        root.add(new File(Size.of(8504156)));
        root.add(new Directory(Name.of("d")));
        root.cd(Name.of("d")).add(new File(Size.of(4060174)));
        root.cd(Name.of("d")).add(new File(Size.of(8033020)));
        root.cd(Name.of("d")).add(new File(Size.of(5626152)));
        root.cd(Name.of("d")).add(new File(Size.of(7214296)));

        List<Name> expectedNames = List.of(Name.of("a"), Name.of("e"));
        List<Name> actualNames = root.getDirectoriesWithTotalSizeOfAtMost(Size.of(100000)).stream()
                .map(directory -> directory.getName())
                .collect(Collectors.toList());
        assertIterableEquals(expectedNames, actualNames);
    }

    @Test
    public void getDirectoriesWithTotalSizeOfAtMostShouldReturnE() {
        Directory root = new Directory(Name.of("/"));
        root.add(new Directory(Name.of("a")));
        root.add(new Directory(Name.of("d")));
        root.cd(Name.of("a")).add(new Directory(Name.of("e")));
        root.cd(Name.of("a")).cd(Name.of("e")).add(new File(Size.of(584)));
        root.cd(Name.of("a")).add(new File(Size.of(2911600)));
        root.cd(Name.of("a")).add(new File(Size.of(2557)));
        root.cd(Name.of("a")).add(new File(Size.of(62596)));
        root.add(new File(Size.of(14848514)));
        root.add(new File(Size.of(8504156)));
        root.add(new Directory(Name.of("d")));
        root.cd(Name.of("d")).add(new File(Size.of(4060174)));
        root.cd(Name.of("d")).add(new File(Size.of(8033020)));
        root.cd(Name.of("d")).add(new File(Size.of(5626152)));
        root.cd(Name.of("d")).add(new File(Size.of(7214296)));

        List<Name> expectedNames = List.of(Name.of("e"));
        List<Name> actualNames = root.getDirectoriesWithTotalSizeOfAtMost(Size.of(100000)).stream()
                .map(directory -> directory.getName())
                .collect(Collectors.toList());
        assertIterableEquals(expectedNames, actualNames);
    }
}
