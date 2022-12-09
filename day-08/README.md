# How to build

```
mvn clean package
```

# How to run

```
java -jar target/advent-of-code-2022-day-08-1.0.0-SNAPSHOT.jar
```

# Some notes

It's the second times I start to model the problem before trying to solve it.

I begin to think that it's not the good approach because, a bad model implies to do some painful stuffs like this:
```java
for (Row row = Row.of(1); row.getValue() < treeGrid.getNbRows(); row = Row.of(row.getValue()+1)) {
    for(Column column = Column.of(1); row.getValue() < treeGrid.getNbColumns();column = Column.of(column.getValue()+1)) {
        // Doing Something...
    }
}
```
My first purpose by doing this advent of code was to improve my skills about clean coding. And we cannot say that this piece of code has been written as it can be read like well-written prose.

It needs a lot of reading and comprehension before understanding what this piece of code do.

So we need to refactor a bit this code to be able to write it make it much more easy to read:
```java
for (Row row : forest.rows()) {
    for (Column column : forest.columns()) {
        // Doing Something...
    }
}
```
I think it's much much easier to read.


Today's puzzle made me realize that making code clear, readable and meaningful can be a strong barrier to performance. Not that I had any performance problems, only that I did a lot of instantiation while solving this puzzle and I think that if I had more volume, I would have had performance problems.