# How to build

```
mvn clean package
```

# How to run

```
java -jar target/advent-of-code-2022-day-09-1.0.0-SNAPSHOT.jar
```

# Some notes

As far as I understood is that we have lists of Things.
Things can be Integer or List.
Things are comparable together if they are both of the same type (Integer or List).

And what if I deal with this problem without any data structure that could complex the problem.
I tell to myself that I could compare token per token and se if I'm able to detect the good order of pairs.

