# How to build

```
mvn clean package
```

# How to run

```
java -jar target/advent-of-code-2022-day-02-1.0.0-SNAPSHOT.jar
```

# Some notes

I started to build the smallest pieces in a TDD approach before building the app.

I firstly built the `HandShape`, then the `Round` and then the `Game`.


The big point of this puzzle was that the interpretation of characters was not the good one.
At the beginning, `HandShape` was containing the code to translate letters X, Y and Z.
But the second puzzle asked to change the way to decrypt these letters so the translation was to deep in the code structure.

I had to refactor the code to have the `Decryptor` in one side and the `HandShape` in another side to split the business logic of the game from the decryption part.