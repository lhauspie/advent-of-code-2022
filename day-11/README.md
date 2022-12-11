# How to build

```
mvn clean package
```

# How to run

```
java -jar target/advent-of-code-2022-day-09-1.0.0-SNAPSHOT.jar
```

# Some notes

The Parsing part will seem to be completely headache, so I decided to hard code the input to describe the Keep Away game before playing. (I translated the text input in Java Code).
So let's try to code the parsing part at the end if I have time.

Very soon I modeled `Monkey` having a list of `Item`s, an `Operation`, a `Condition`, a true `Monkey` (the monkey to throw item in case of condition success), a false `Monkey` (the monkey to throw item in case of condition failure) and a numberOfItemInspections.

Then I coded the KeepAwayGame.

Ok I encountered a bug, and I spent a lot of time to understand what happened.
Every unit tests gone green but the puzzle result was wrong oO.
After displaying the `Monkey`s, I noticed that some worry levels was negative oO.
In fact, I developed the worry level as `int` instead of as `long`.
And a lot of multiplications result to `int` overflowing.

I finished writing a trivial parser that is completely specific to the input specificity.
For instance, I only support "is divisible by" `Condition`, no other `Condition`.

For this puzzle functional interfaces (lambda) helped a lot.
They make possible to include some specific `Operation` and `Condition` per monkey.

