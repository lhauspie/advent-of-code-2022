# How to build

```
mvn clean package
```

# How to run

```
java -jar target/advent-of-code-2022-day-04-1.0.0-SNAPSHOT.jar
```

# Some notes
The puzzle is not so hard.
It's just about stacks and fortunately java provide such a data structure.

The model is reflecting the simplicity of the puzzle.
We have a `Ship` composed of several `Stack`s of `MarkedCrate`s.

The big problem in this puzzle seems to be the parsing.

## Parser testability
It was quite difficult to write the code of the `InputReader` in TDD because the parsing process needs to already have complex input.
The parsing algorithm cannot really be developed iteratively.
So this phase was a big one.

## Second Puzzle
The second puzzle include the concept of a `Mover`.
During the first puzzle I had the feeling that I had to code some kind of Cargo Crane but without really knowing how to design it in the model.

The solution came from the second part of this puzzle.
The Cargo Crane has a reference to the ship to move the crates on according to the rearrangement procedure (`Move`s).
So we're now able to change the way to move the `Crate`s without changing the `Ship` structure.
We could now imagine a new `CrateMover9999` with other features like reordering in alphabetic order the `Crate`s before depositing them to the new `Position`.