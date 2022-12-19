# How to build

```
mvn clean package
```

# How to run

```
java -jar target/advent-of-code-2022-day-17-1.0.0-SNAPSHOT.jar
```

# Some notes

A lot of boilerplate code to implement the `VerticalChamber`, `Piece`s and `Move`s engine.

It's important to notice that for this puzzle I chose to make the Position mutable (cf. `MutablePosition`) because I was afraid that the second part will ask to simulate full lines to be break like a in the tetris game.

But it's not a good practice because this kind of code will move the Piece position without moving down the rocks that compose the Piece:
```java
Rock rock = new Cross(MutablePosition.of(10, 10));
rock.getPosition().down();
```

## Part 2

I cheated a bit on this one too because I had performance issues.
Thanks to some blog posts I understood that we should looking from a redundant pattern in the Tower Topography.
We I mean by Tower Topography is the form of the highest lines of the Tower.

This is the notes I took to develop my calculation :
```java
// TODO : I need to detect a loop and/or a pattern to avoid simulating all the pieces to fall down
//        when I detect a loop, I should be able to know the number of fallen blocks in one loop
//        and then calculating the corresponding tower tall to jump to a more advanced state without simulating all the pieces
// |......|
// |...###| <-- end of the loop
// |.##...|
// |#.....|
// |......|
// |...###| <-- Start of the loop
// |.##...|
// |#.....|
// Let say, 2 pieces fell down for a tower tall of +4 during one loop
// I can now calculate the number of loops to simulate the rest of the simulation
// Let say 23 pieces already fell down and the current tower tall is 14
// I have to simulate this number of loop : (1000000 - 23) / 2 = 499988,5 rounded at inferior integer = 499988 (I have to simulate 499988 loops)
// During one loop the tower is +4 taller, so the tower tall of the tower after 499988 loops is : 499988 * 4 = 1999952
// I know now that the tower will be 1999952 units taller after doing the previous 499988 loops
// 14 (tower tall at the loop detection time) + 1999952 (tower tall after doing 499988 loops) = 1999966
// It's not yet finished because it remains pieces to fall down => total pieces fell down = 499988 * 2 + 23 = 999999
// I have to make (1000000 - 999999) = 1 more pieces to fall down
// This tower tall reaches 15 units
// So the final tower tall is : 15 (tower tall at detection + left pieces) + 1999952 (tower tall after looping) = 1999967
```

Concerning the loop detection, I chosen to represent the N highest lines of the Tower with a simple String.

