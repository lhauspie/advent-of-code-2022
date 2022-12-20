# How to build

```
mvn clean package
```

# How to run

```
java -jar target/advent-of-code-2022-day-18-1.0.0-SNAPSHOT.jar
```

# Some notes

First part is very very easy to resolve. Just having a Set of LavaDroplet and then decrement the surfaceArea of each
LavaDroplet when there is another droplet connected.

## Part 2

Ok, I think the approach is to start with a big cube containing all the droplets and then removing the droplets in the
outer layer. A little example:
Starting with a cube of 5x5x5. Remove the droplets in outer layer that are not in the input.

Before running and trying to resolve the puzzle, let's check the size of the start cube to be sur I can implement this
solution without having memory or performance issues. After parsing the input, it seems the biggest cube that could
contain all the LavaDroplets is:
Min LavaDroplet{x=1, y=0, z=1} Max LavaDroplet{x=21, y=20, z=20} So we're talking about 20x20x20 objects to be
instantiated = 800, pretty easy to manage.

Let's go to implement this strategy. This strategy cannot work because we're not sure if there is something on another
face that can justify to fulfill the empty Point3D.

Let's simplify the problem in a 2D world.

```
.......
.####..
.#.....
.#...#.
.####..
```

In this case we don't have any air pocket but with the previous approach, we could fulfill the center as it's considered
as air pocket.

It should be possible to do a kind of exploration to determine the Point3D reachable form the outside to the inside.

I succeed to find the result for a little cube of 5x5x5 but resolving the puzzle for a cube of 20x20x20 led to a
java.lang.StackOverflowError.

```java
private void exploreRecursively(Point3D point3D,Set<Point3D> exploredPoints){
        if(points3D.contains(point3D)){
        // collide with a point3D of lava droplet, stop exploration
        return;
        }
        if(outsideTheOuterBox(point3D)){
        // collide with a wall of the labyrinth, stop exploration
        return;
        }
        if(exploredPoints.contains(point3D)){
        // point already explored, stop exploration
        return;
        }
        exploredPoints.add(point3D);
        exploreRecursively(point3D.up(),exploredPoints);
        exploreRecursively(point3D.down(),exploredPoints);
        exploreRecursively(point3D.left(),exploredPoints);
        exploreRecursively(point3D.right(),exploredPoints);
        exploreRecursively(point3D.front(),exploredPoints);
        exploreRecursively(point3D.back(),exploredPoints);
        }
```

Let's try to implement this exploration in an iterative way instead of recursive.

Ok, the naive iterative way led to java.lang.OutOfMemoryError because of the instantiation of a big amount of Point3D to
stack them.

Ah nope, erratum, I just had a bug in my code, this is my code after the fix:

```java
private void exploreIteratively(Point3D point3D,Set<Point3D> exploredPoints) {
    Stack<Point3D> pointsToBeExplored = new Stack<>();
    pointsToBeExplored.push(point3D);
    while (!pointsToBeExplored.isEmpty()) {
        Point3D pointToBeEplored = pointsToBeExplored.pop();
        if (!points3D.contains(pointToBeEplored) && !outsideTheOuterBox(pointToBeEplored) && !exploredPoints.contains(pointToBeEplored)) {
            exploredPoints.add(pointToBeEplored);
            pointsToBeExplored.push(pointToBeEplored.up());
            pointsToBeExplored.push(pointToBeEplored.down());
            pointsToBeExplored.push(pointToBeEplored.left());
            pointsToBeExplored.push(pointToBeEplored.right());
            pointsToBeExplored.push(pointToBeEplored.front());
            pointsToBeExplored.push(pointToBeEplored.back());
        }
    }
}
```

Let's try another approach like in day-12. I adopted this approach before debugging the previous version. After
debugging previous version, I realized that this third approach has better performance than the previous one.

