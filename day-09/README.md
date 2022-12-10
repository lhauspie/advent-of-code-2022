# How to build

```
mvn clean package
```

# How to run

```
java -jar target/advent-of-code-2022-day-09-1.0.0-SNAPSHOT.jar
```

# Some notes

Let's get started with the parsing for this time and just try to have a code as clean as possible.

only after 2 or 3 tests, I realized the problem cannot be resolved only by reading the entry and try to calculate the result.
This problem needs to follow the tail according to the head movement so let's write the code to calculate the position of the tail after a head movement.

TDD seems to be perfect to let emerge the design of the calculation.
The rules seem to be simple but implementing them without test could be bold.

As usually the second part of the puzzle implies to have a better understanding of the global problem to solve.
So, I had to modify the code to not have a `Head` and a `Tail` classes but to only have One `RopeNode`s class that can compose a `Rope`.

I used the Observer/Observable pattern to let each `RopeNode` to observe the previous `RopeNode` of the `Rope`. By this way I only have a "simple" function to implement the following rule (cf. `RopeNode#update(RopeNode node))`.

NB : I forgot to commit/push after each test :confused:.