# How to build

```
mvn clean package
```

# How to run

```
java -jar target/advent-of-code-2022-day-23-1.0.0-SNAPSHOT.jar
```

# Some notes

## Analyse des volumes

On va avoir des soucis de perf avec ce puzzle.
Il y a 2731 Elves à simuler.

Ce qui signifie qu'on va avoir à faire 2731 * 2731 comparaison pour savoir si 2 Elves ont choisi la même destination.

De même, les Positions devraient être immutables pour garantir leur intégrité et être sûr que le code ne fasse pas d'effet de bord qui pourrait perturber le calcul des nouvelles position.

Donc pour qu'un elf puisse savoir si d'autres elfes sont présent dans les directions orthognales et diagonales, il lui faudra instantier 8 Positions.

La quantité d'instances à créer sera donc de 2731 * 10 * 8 pour la simulation du round 1 de ce puzzle.
Une optimisation possible serait de conserver les positions en mémoire pour ne pas avoir à les recréer (une sorte de cache).
C'est réalisable avec le pattern factory.

