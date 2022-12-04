# How to build

```
mvn clean package
```

# How to run

```
java -jar target/advent-of-code-2022-day-01-1.0.0-SNAPSHOT.jar
```

# Some notes

For this puzzle I tried to have a Software Crafting approach.
So I tried to respect some Clean Code principles:
- Make the implicit explicit
- No Primitive Obsession
- Use Value Object
- Write the code in business class, not in services
- Have good function names
- KISS
- DRY
- Single Responsibility Principle

And I will try to follow this during all this Advent of Code challenge.

It's possible to follow every development steps in detail with the commits.
```
git log f9a5ee364e53296bb67b68edff6cd7df485631b4..9e04b8a297656a8585053369da4f441ee1aa4a64
```