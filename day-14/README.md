# How to build

```
mvn clean package
```

# How to run

```
java -jar target/advent-of-code-2022-day-09-1.0.0-SNAPSHOT.jar
```

# Some notes

I was not proud of my code after the puzzle resolution so I decided to refactor my code to make it more meaningful.

Fortunately I had my test suite to be run after each refactor because I broke several times the result during the refactoring process.

They helped me to keep a working well software to resolve the puzzles in the same way.

So now I have a more expressive model with a good repartition of functions in their own model.

To compare the version of my code before and after the refactoring, you can just type the command `git diff c93018f089c05a9cd688f90d6f82f055bc8adc38..733cd3019489580d60b1622efacc28af550526dd`.
I could have gone further in the refactoring for moving the simulation inside the cave, or for creating `Rock` and `RestingSand` to make a difference in `Cave`, but I miss time to go further in the clean code approach.
```java [Cave.java]
private Set<Position> rocks = new HashSet<>();
private Set<Position> restingSandUnits = new HashSet<>();
```
