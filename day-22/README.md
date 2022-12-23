# How to build

```
mvn clean package
```

# How to run

```
java -jar target/advent-of-code-2022-day-22-1.0.0-SNAPSHOT.jar
```

# Some notes
This is a map route.
The input map is 150x200.
That is a maximum of 30000 positions.
This is totally manageable from a memory point of view.

The rest of the input contains the move instructions.
There are 4000 of them (including moves and rotations).

The map is a torus.
Like every time I'm in the presence of a torus, I like to model it with linked lists.

Here, we could have positions linked to a given position.
These positions are the cardinal points.

A rotation order could be used to compute the direction in which to move next.
A `Position` can be an empty space or not.

So we can move forward as many times as we want or until we meet a wall.

The starting direction is `EAST`.
The starting position is the top left position possible.

After a lot of code, I finally solved the first part.


## Part 2

Basically, in the first round, I modeled a `Board` and an `Explorer` that does the work of walking the `Board`.

This separation saves me a bit because I normally only have to replace the `Board` with a `Cube` and everything should work out as planned.

My biggest problem was the approach I used to add the Tiles to the Board.
I linked the Tiles as I added them.
Except that now I have to wait for the end of the Tiles additions to make the links.

Well, I see that the example and my input are not the same.
The solution I'm going to write will probably not be compatible with all possible inputs.

Another little problem that I see coming is that once you change the face of the cube, the cardinal points are a little changed.
We'll have to pay attention to that.


It was really hard to make a mental representation of the cube in 3D.
I had to do some schematics and some calculations to find the right way to go through the surfaces of the cube.

I am really impressed by the performance of the program.
The answer comes out in ~70ms.
