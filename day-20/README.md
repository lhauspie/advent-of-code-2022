# How to build

```
mvn clean package
```

# How to run

```
java -jar target/advent-of-code-2022-day-20-1.0.0-SNAPSHOT.jar
```

# Some notes

When I first read the puzzle statement, I thought I would model this problem with a custom chained list structure.

Since I'm starting to know Advent of Code and its mania for making round 2 more complex, I figured I'd have to optimize the movement of the numbers that compose the encrypted sequence.

I lost about 3 hours with modulo, index -1 +1.
And then I gave up this idea of optimizing everything from the start.
And I did well.

I solved the 2 parts of this puzzle in 2 hours.


I got into the habit of looking at the input content before implementing the solution to make sure of the volumes.
And I must say that I am impressed with the performance of this solution.
The approach is very naive and it answers the second problem in 1sec4, which I find honorable.

Just for fun, here is the first code that made me want to tear my hair out:
```java
private void moveForward(Number number) {
    int previousPosition = number.getCurrentPosition();
    int nextPosition     = previousPosition + number.getValue();
    if (nextPosition >= sequenceLength) {
        nextPosition     = nextPosition % (sequenceLength - 1) + 1;
    }

    moveToNewPosition(number, previousPosition, nextPosition);
}

private void moveBackward(Number number) {
    int previousPosition = number.getCurrentPosition();
    int nextPosition     = previousPosition + number.getValue();
    nextPosition         = nextPosition % (sequenceLength) + (nextPosition / sequenceLength);
    if (nextPosition < 0) {
        nextPosition = nextPosition + sequenceLength - 1;
    }

    moveToNewPosition(number, previousPosition, nextPosition);
}
```

And as you can imagine, everything went wrong.

## Part 2

The second part asks to increase the volumes.
We increase the values of the numbers significantly and we ask to decrypt the sequence 10 times.

The solution is a simple modulo on the number of elements in the sequence (don't forget the "-1" because otherwise, we don't get the right result).