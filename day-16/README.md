# How to build

```
mvn clean package
```

# How to run

```
java -jar target/advent-of-code-2022-day-16-1.0.0-SNAPSHOT.jar
```

# Some notes

It seems the problem is about a graph.
I'm very bad to resolve graph problem.

I think day and night about this problem but the solution doesn't come... And it seems that I am not the only one ==> https://github.com/tginsberg/advent-2022-kotlin/tree/main/src/main/kotlin/com/ginsberg/advent2022.

So I give up on this puzzle and I'll come back to it later so as not to lose the thread of the advent calendar.

I have the impression to have fallen on a "Mon-Cheri" for day 16.


It's day-20 and I had an idea this morning.
I could explore first once the graph to know the shortest path from the `AA` `Valve` and all the others.
Then, sort the `Valve`s in `FLowRate` decreasing order.
Then, try to reach the highest `Valve` from `AA`.

At each valve I walk through during the way, I can ask if it's profitable to open the currentValve or not.
Opening the currentValve is profitable if the `FlowRate` of this last one is greater than the time to reach the biggest `Valve`.

Let's take a little example :
```
AA(0) --> BB(3) --> C(30)
```

Going from `AA` to `CC` is going through `BB`. This one has a `FLowRate` of 3 and the CC `Valve` has a `FlowRate` of 30. If I take one minute to open `BB` on the way, I'll lost 30 from CC. So the difference of pressure is 27.

By reading again this explanation, I think we could have a problem because in the example, `BB` is not reachable anymore when we reached `CC`.
The profitability of opening a Valve on the way is not the distance from `BB` to `CC` but the distance from `CC` to `BB`.
Indeed, if there is no way to go back to BB from `CC`, the condition may not be exactly the same.

Question: are there any cases where it's better to give up a Valve than to open it on the way ?



