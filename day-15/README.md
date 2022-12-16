# How to build

```
mvn clean package
```

# How to run

```
java -jar target/advent-of-code-2022-day-15-1.0.0-SNAPSHOT.jar
```

# Some notes

One more time I started with a model.
The principle was to explore the Cave according to each sensor.
With example data, it's working well.

After running the first puzzle resolver, I seem to have an infinite loop.
Debugging reveals that the first sensor is `Sensor at x=33790, y=3243415: closest beacon is at x=-355567, y=3900317` that is meaning there is a lot of positions to explore (abs(s.x - b.x) * abs(s.y - b.y) / 2), in this case : abs(33790 - -355567)389357 * abs(3243415 - 3900317) = 255.769.392.014 what not acceptable for doing this for 38 sensors.

So my algorithm seems to be not adapted to the problem to solve. because I have to create only for the first sensor 
I learned... before rushing to development phase, make sur of the constraints.

So one more time, beginning by the model leads to errors and poor design due to a partial understanding of the problem.

Let's have another approach to avoid creating so much objects in memory.

I think there is a simple calculation formula to define how many positions doesn't contain other beacon than the one of a Sensor.

Let's say sensor is at 0,0 and beacon 3,3.
```
S...
....
....
...B
```

So the number of positions in the same `y` of the B that doesn't contain is the double of the `x` distance between S and B. In this case, it's 6.
```
......#......
.....###.....
....#####....
...#######...
..#########..
.###########.
######S######
.###########.
..#########..
...######B...
....#####....
.....###.....
......#......
```

The list of positions are `(B.x-1, B.y)` --> `(B.x-7, B.y)` 

So by focusing the problem to solve and not the model, we can have a more performant solution. And once we have a solution, we improve it with clean code principles. Doing clean code from the beginning seems to lead to problems when adapting the model to the problem.


## Second part

Whouaw... Finding the beacon position seems to be finding the only Position missing in a matrix of size 4000000 * 4000000 (= 16000000000000) too much to instantiate all the possible positions and then remove the one we find on each line.
Having positions of one line took 3987 ms, so impossible to try this for lines from 0 to 4000000... it would take 185 days oO.

I have to adopt a new approach.

I succeeded to improve the perf of my algo

## Practices

Yesterday I heard Uncle Bob saying, you should have a Test structure different from the Production Code structure.
I'll try to create classes different from MyClassTest and replace that with `MyClassInThisSituationTest` to be more specific at class level.
It should be clearer for newcomers.
Let's try.

It represents the disadvantage to always run all tests after a modification.
Test class dedicated to a production Class allows to run only this class when you work on it.
So don't forget to run all tests after each modification.
