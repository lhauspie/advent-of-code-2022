# How to build

```
mvn clean package
```

# How to run

```
java -jar target/advent-of-code-2022-day-13-1.0.0-SNAPSHOT.jar
```

# Some notes

As far as I understood is that we have lists of Things.
Things can be Integer or List.
Things are comparable together if they are both of the same type (Integer or List).

And what if I deal with this problem without any data structure that could complex the problem.
I tell to myself that I could compare token per token and se if I'm able to detect the good order of pairs.

It seems there is a problem in the puzzle statements.
`Right` order means `Left` is smaller than `Right`. But the puzzle is resolved by counting the number of `Right` smaller than `Left`. oO.

Ah it's not a problem in puzlle statement, it's one character in thousands that make me failed : `!` oO oO

## Second Part

I'm so so happy to managed my `SignalAnalyzer` as a `Comparator`.
Second part is about sorting, so I don't have too much work to have the second part as resolved :D

Second part took me 20 minutes to resolve.

The first half part of my job is done now. Let's refactor the code for clean code.

