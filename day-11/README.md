# How to build

```
mvn clean package
```

# How to run

```
java -jar target/advent-of-code-2022-day-11-1.0.0-SNAPSHOT.jar
```

# Some notes

The Parsing part will seem to be completely headache, so I decided to hard code the input to describe the `KeepAwayGame` before playing. (I translated the text input in Java Code).
So let's try to code the parsing part at the end if I have time.

Very soon I modeled `Monkey` having a list of `Item`s, an `Operation`, a `Condition`, a true `Monkey` (the monkey to throw item in case of condition success), a false `Monkey` (the monkey to throw item in case of condition failure) and a numberOfItemInspections.

Then I coded the `KeepAwayGame`.

Ok I encountered a bug, and I spent a lot of time to understand what happened.
Every unit tests gone green but the puzzle result was wrong oO.
After displaying the `Monkey`s, I noticed that some worry levels was negative oO.
In fact, I developed the worry level as `int` instead of as `long` and a lot of multiplications resulted to `int` overflowing.

I finished writing a trivial parser that is completely specific to the input specificity.
For instance, I only support "is divisible by" `Condition`, no other `Condition`.

For this puzzle, functional interfaces (lambda) helped a lot.
They make possible to include some specific `Operation` and `Condition` per monkey.
```
    monkey0.setOperation(worryLevel -> worryLevel * 19);
    monkey0.setCondition(worryLevel -> worryLevel % 23 == 0);
```

## Second part

As my goal is to be able to provide both puzzle results, I have to find a way to change the rule of the item inspection to avoid the division by 3.
As, at the end of part one, the rule is in the `Item` (the deeper object of my model) I can't have both result in one execution unless I duplicate a lot of code to change only this variable.
It was simpler to attach the worryLevel (and its reduction after inspection) to the `Item` for the first part but it doesn't really reflect the reality.
```java
public class Item {
    ...
    public void inspect(Inspection inspection) {
        this.worryLevel = this.worryLevel / 3L;
    }
    ...
}
```
I think I have to affect the worryLevel to item inside a central player (the item's owner in the puzzle statements).

### And then the light goes ON (after several long hours of thinking about it)

Ok I used another approach.
I finally left the worry level inside the `Item` but I changed the way and the responsibility of the calculation.
The responsibility to calculate the new worry level seems to be the one of an item's `Owner`.
The items are owned by someone, and it's the responsibility of this `Owner` to worry or not about the `Item` according to the kind of `Inspection` the monkeys do.
An `Item` that doesn't belong to anyone doesn't have a chance to increase its level of concern, does it?

So now, the `KeepAwayGame` takes:
- a central player that is the `Owner` of items
- the list of `Monkey`s
- and the number of rounds to play

With this model we can have several profiles of `Owner`:
- the `RelaxOwner` who is very easy to calm down after `Monkey`'s `Inspection`
- and the `WorriedOwner` who are very hard to calm down

So the model seems to be more flexible because we could code a third `Owner` behaviour very easily.


### But it's not the end of the story

After solving the problem about `Item` inspection worry level reduction, I had another problem.

As the worry level is not decreasing in this second part, I think that I have a problem with `long`.
I might have to change again `long` to `BigInteger`.

Ok, after trying this approach, my algorithm is only capable of running ~350 rounds.
Hmm... Here again, I spent hours to try to solve this problem but I didn't really see how to run more than this number of round.
Ok, I had to search help from internet.

Thanks to this [blog post](https://observablehq.com/@jwolondon/advent-of-code-2022-day-11) I understood that if we take the product of all monkeys' divisors we can reduce the value of worry level to avoid overflow and unperformant operations on really "BigInteger" without taking the risk to make a bad operation.