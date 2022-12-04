# How to build

```
mvn clean package
```

# How to run

```
java -jar target/advent-of-code-2022-day-04-1.0.0-SNAPSHOT.jar
```

# Some notes

For this one, I started to develop something working but with bad practices and then try to refactor it step by step to see if it's possible to improve the code to make it readable and maintainable.

My first try to resolve the second puzzle was bugged because I didn't find the good answer. So it shows how it can be hard to develop without any test to be sure some code piece is working well.

## Make code testable

Before refactoring anything we should have tests to be sure to not introduce regression.
Let's start by modifying the code to allow to assert the result of the puzzle resolution.
The solution is simply to make the resolveXxx functions as public.
```java
public static int resolveFirstPuzzle(Scanner scanner) {}
```
And then write a test to be sure to not have regression during the refactoring.
```java
public void resolveFirstPuzzle() {
    var input = """
            10-20,30-40
            30-40,10-20
            10-20,10-20
            10-20,20-30
            20-30,10-20
            10-30,20-40
            20-40,10-30
            10-50,20-30
            20-30,10-50
            """;
    var scanner = new Scanner(input);
    // 10-20,10-20 full contain
    // 10-50,20-30 full contain
    // 20-30,10-50 full contain
    assertEquals(3, Main.resolveFirstPuzzle(scanner));
}
```

## Give meaning to the code

### Give meaning to the conditions
First step is to give meaningful to the different conditions.
This kind of condition doesn't own any business sens:
```java
if (firstRange.start <= secondRange.start && secondRange.start <= firstRange.stop
        || firstRange.start <= secondRange.stop && secondRange.stop <= firstRange.stop
        || secondRange.start <= firstRange.start && firstRange.start <= secondRange.stop
        || secondRange.start <= firstRange.stop && firstRange.stop <= secondRange.stop){}
```

It could be nice to have something like:
```java
if (firstRange.overlap(secondRange)) {}
```

It's much simpler to understand.

### Give meaning to the variables
In a same approach, `count++` is not really meaningful. What are we counting? We don't really know unless we read the function content.

I rename some variables to give meaning to the code.
- `count` => `numberOfOverlappingRanges`
- `firstRange`

### Simplify complex code
Sometime, during the development process, we write some if else if conditions that could be simplified after some refactoring.

For instance:
```java
if (firstRange.fullyContains(secondRange)) {
    numberOfOverlappingRanges++;
} else if (secondRange.fullyContains(firstRange)) {
    numberOfOverlappingRanges++;
}
```
could simply be written:
```java
if (firstRange.fullyContains(secondRange) || secondRange.fullyContains(firstRange)) {
    numberOfOverlappingRanges++;
}
```

## Be DRY (Don't Repeat Yourself)
In the `Main` class, there some duplicated code we could factorise:
```java
String nextLine = scanner.nextLine();
String[] nextSplitedLine = nextLine.split(",");
String[] firstIntStr = nextSplitedLine[0].split("-");
String[] secondIntStr = nextSplitedLine[1].split("-");
Range firstRange = new Range(Integer.parseInt(firstIntStr[0]), Integer.parseInt(firstIntStr[1]));
Range secondRange = new Range(Integer.parseInt(secondIntStr[0]), Integer.parseInt(secondIntStr[1]));
```

Don't forget to keep the code meaningful.
In the puzzle, the `Range`s to be compared are named a `Pair`

So we could just extract this duplicated piece of code to a private function:
```java
private static Pair parsePair(String line) {
    String[] splitLine = line.split(",");
    String[] firstIntStr = splitLine[0].split("-");
    String[] secondIntStr = splitLine[1].split("-");
    return new Pair(
            new Range(Integer.parseInt(firstIntStr[0]), Integer.parseInt(firstIntStr[1])),
            new Range(Integer.parseInt(secondIntStr[0]), Integer.parseInt(secondIntStr[1]))
    );
}
```

After this refactoring, we needed to update the conditions:
```java
if (pair.left.fullyContains(pair.right) || pair.right.fullyContains(pair.left)) {
    numberOfOverlappingRanges++;
}
```

We might desire to move this piece of code inside the `Pair` class:
```java
public record Pair(Range left, Range right) {
    public boolean isFullyContain() {
        return left.fullyContains(right) || right.fullyContains(left);
    }
}
```

## Separate the business logic from infrastructure code

For now, everything is inside the `Main` class, so it's not easy to maintain the code and to find the good piece of code to modify.

Let's separate the business logic in the `model` package and the parser in the `adapter` package.


## Conclusion

I improved the code to make it:
- testable at every level
- understandable to every new-comers
- maintainable

