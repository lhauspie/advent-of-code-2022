# How to build

```
mvn clean package
```

# How to run

```
java -jar target/advent-of-code-2022-day-21-1.0.0-SNAPSHOT.jar
```

# Some notes

Well, the first part of puzzle is very simple.
But the last time it was as simple as this, it was for day 18 and the LavaDroplet.

Before reading the second part let's try to refactor the code because for me, this specific class is a Code Smell because it encapsulate 2 different intention:
```java
class Monkey {
    private String id;
    private String leftMonkeyId;
    private String rightMonkeyId;
    private Long value;
    private Operation operation;

    public Monkey(String id, String leftMonkeyId, String rightMonkeyId, Operation operation) {
        this.id = id;
        this.leftMonkeyId = leftMonkeyId;
        this.rightMonkeyId = rightMonkeyId;
        this.operation = operation;
    }

    public Monkey(String id, Long value) {
        this.id = id;
        this.value = value;
    }

    public Long getValue() {
        return value == null ? operation.calculate(leftMonkeyId, rightMonkeyId) : value;
    }

    public String getId() {
        return id;
    }
}
```

## Part 2

I had to think very hard to revert each operation.

I'm not totally satisfied of my implementation and the code seems to be a bit not testable.

Let's try to refactor the code to make it testable.