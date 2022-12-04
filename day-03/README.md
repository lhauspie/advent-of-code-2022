# How to build

```
mvn clean package
```

# How to run

```
java -jar target/advent-of-code-2022-day-03-1.0.0-SNAPSHOT.jar
```

# Some notes

Usually I code in TDD and I start with the smallest object I can but for this puzzle day, I started with the model without any function.
Just to see how it will impact the tests and codes.

`Rucksack` is composed of 2 `Compartment`s (left and right).
Each `Compartment` contains a list of `Item`s.
Each `Item` is composed of an `ItemType`.
An `ItemType` has an associated `Priority`.

My code was less testable than previous days.
Maybe because the puzzle was not compliant with testability.
Maybe it was because I wrote the model before testing anything.

But the good point was that the model is pure without any consideration about how the objects will be built.