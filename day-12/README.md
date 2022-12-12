# How to build

```
mvn clean package
```

# How to run

```
java -jar target/advent-of-code-2022-day-09-1.0.0-SNAPSHOT.jar
```

# Some notes

For this puzzle it seems pretty clear we have to code a Map describing the Topology and a Person how want to go through this map to reach a specific Point from a StartPosition.

The way to reach the specific Point seems specific to the Person and maybe to the used tools (Climbing Gear for instance).

The first difficulty I can anticipate is the **shortest** path. It's pretty easy to only find a path but more complicated to find the shortest path.

The second specificity to represent a difficulty is that it's possible to climb down to a much lower position.

For this Puzzle I decided to not start by an over-engineered model that could be difficult to refactor after the first part is done.
I started to code everything in the PuzzleResolver and then extract the part I need to hav clean code.
So I decided to not refactor my code before the second part of this puzzle as I usualy did.

I fight myself to not code a `Person` how can have `Tool`s or not. This `Person` could know the `Heightmap` and decide to walk throw the map according to the difficulty of the `Path` (height difference between positions in path).

My first version pass all the tests but it encounters stackoverflow issues because I used a recursive approach.
Let's try with an iterative approach.

The problem with the recursive approach is we have to wait the end of a branch exploration to go through another, with iterative approach, we can explore all the next steps at once.
My approach is to take every already explored Position and mark the four neighbour with the number of steps of the explored Position + 1.
This approach results in a kind of diamond exploration (every Position starting with '.' are marked as explored, the number is the number of steps):
```
|.00|.01|.02|.19|.18|.17|.16|.15|.16|.17|.18|.19|.20|.21|.22|.23|.24|.25|012|012|012|012|012|012|012|012|012|012|012|012|012|
|.01|.02|.03|.20|024|023|023|.14|.15|.16|.17|.18|.19|.20|.21|.22|.23|.24|.25|012|012|012|012|012|012|012|012|012|012|012|012|
|.02|.03|.04|.21|025|025|023|.13|.16|.17|.18|.19|.20|.21|.22|.23|.24|.25|012|012|012|012|012|012|012|012|012|012|012|012|012|
|.03|.04|.05|.22|.23|.24|.25|.12|.17|.18|.19|.20|.21|.22|.23|.24|.25|012|012|012|012|012|012|012|012|012|012|012|012|012|012|
|.04|.05|.06|.07|.08|.09|.10|.11|.18|.19|.20|.21|.22|.23|.24|.25|012|012|012|012|012|012|012|012|012|012|012|012|012|012|012|
|012|012|.25|.24|.23|.22|.21|.20|.19|.20|.21|.22|.23|.24|.25|012|012|012|012|012|012|012|012|012|012|012|012|012|012|012|012|
|012|012|012|.25|.24|.23|.22|.21|.20|.21|.22|.23|.24|.25|012|012|012|012|012|012|012|012|012|012|012|012|012|012|012|012|012|
|012|012|012|012|.25|.24|.23|.22|.21|.22|.23|.24|.25|012|012|012|012|012|012|012|012|012|012|012|012|012|012|012|012|012|012|
|012|012|012|012|012|.25|.24|.23|.22|.23|.24|.25|012|012|012|012|012|012|012|012|012|012|012|012|012|012|012|012|012|012|012|
|012|012|012|012|012|012|.25|.24|.23|.24|.25|012|012|012|012|012|012|012|012|012|012|012|012|012|012|012|012|012|012|012|012|
|012|012|012|012|012|012|012|.25|.24|.25|012|012|012|012|012|012|012|012|012|012|012|012|012|012|012|012|012|012|012|012|012|
|012|012|012|012|012|012|012|012|.25|012|012|012|012|012|012|012|012|012|012|012|012|012|012|012|012|012|012|012|012|012|012|
|012|012|012|012|012|012|012|012|012|012|012|012|012|012|012|012|012|012|012|012|012|012|012|012|012|012|012|012|012|012|012|
```

This solution is much, much faster.

## Part 2

The first solution coming to me is to go from the end 'E' and stop the exploration the first time we find an altitude of 'a'.
I have to assure the way back is possible without any tool (max climbing altitude should be 1).


First of all, I need to refactor my code because it's pretty ugly code.

