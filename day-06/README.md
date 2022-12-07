# How to build

```
mvn clean package
```

# How to run

```
java -jar target/advent-of-code-2022-day-04-1.0.0-SNAPSHOT.jar
```

# Some notes

As almost usually the second part of this puzzle is a game-changer.
Now we have two marker types with different significations:
- Start of Packet Marker
- Start of Message Marker

A marker is considered valid if it meets the following conditions:
- It has the good size (4 in case of start of packet and 14 for start of message)
- It is composed only of distinct characters

The crafting approach says we fail fast, so we should have this kind of code to avoid creation of wrong object:
```
protected Marker(Position position, String value) {
    if (value.length() == getMarkerSize()) {
        throw new IllegalArgumentException("length is not correct");
    }
    if (!isOnlyComposedOfDistinctChars(value)) {
        throw new IllegalArgumentException("there are duplicates characters");
    }
    this.position = position;
    this.value = value;
}
```

But it's not really possible in my case because of the nature of the research and the way I implemented it.
This piece of code was pretty easy to read:
```
public Marker nextMarker() {
    Marker marker = Marker.of(getValue().substring(index, index + Marker.MARKER_SIZE));
    index++;
    return marker;
}

public int getNumberOfCharsFromBeginningOfBufferToEndOfFirstStartOfPacketMarker() {
    while (!nextMarker().isStartOfPacketMarker()) {
        // do nothing because we don't care about the value of the marker
    }
    return index + Marker.MARKER_SIZE - 1;
}
```

Two problem with this approach:
- The index is shared between two functions, so we expect a side effect to make everything to work well. What would arrive if we change the implementation of `nextMarker` ? 🤔
- As the creation of a wrong `Marker` is not possible, everything is falling apart. You would say, I just have to catch the exception, but by doing this, I prevent to increment the index (`index++`).

I think I have to completely review the conception of the puzzle solution.


At the end of the first part of the puzzle, I had a `Marker` object and a `Signal` object (see the `model.v1` package). And the `Signal` was autonomous to retrieve the position of the next `Marker` to check its validity and so on to finally find the "number of characters from the beginning of the buffer to the end of the first such four-character marker".

But if we take care about the language used in the puzzle statements, the author is talking about a `Device` receiving a `Signal` to be analysed by a `SubRoutine`. Let's try to model this as is and see if it's enough modular to add features.



After a lot of refactoring and refactoring I concluded that the real rule to validate a `Marker` is that it should contain only distinct characters. The size is not a validation rule.

I still tried to keep the validation of the Marker length. This implied the creation of four classes instead of only one.


Okay, I finished coding the most explicit model.
But it is at the cost of a significant number of classes.

The `Device` seems to be useless. It could be useful if we had in the near future to add some features to the `Device`, which I highly doubt.