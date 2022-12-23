# How to build

```
mvn clean package
```

# How to run

```
java -jar target/advent-of-code-2022-day-22-1.0.0-SNAPSHOT.jar
```

# Some notes

Il s'agit d'un parcours de carte.
La carte de l'input fait 150x150.
Soit un maximum de 22500 positions.
Ce qui est totalement gérable d'un point de vue mémoire.

Le reste de l'input contient les instructions de déplacement.
Il y en a 4000 (incluant les mouvement et les rotations).

La map est un tore.
Comme à chaque fois que je suis en présence d'un tore, j'aime bien modeliser ça avec des liste chainée.

Ici, on pourrait avoir des positions liées à une position donnée.
Ce sont les points cardinaux.

Un ordre de rotation pourrait permettre de calculer la direction dans laquelle avancer au prochain mouvement.
Une Position peut-être un espace vide ou un mur.

Donc on peut avancer le nombre de fois demandée ou jusqu'à rencontrer un mur.

La direction de départ est Est.
La position de départ la position la plus en haut à gauche possible


Apres une bonne quantité de code, j'ai finalement résolu le puzzle 1.


## Part 2

En gros, au premier tour, j'ai modelisé une Board et un explorateur qui fait le travail de parcourir la Board.

Cette séparation me sauve un peu car j'ai normalement qu'à remplacer la Board par un Cub et tout devrais se dérouler comme prévu.

Mon plus gros problème, c'est l'approche que j'ai utilisé pour ajouter les Tiles à la Board.
J'ai fait le lien entre les Tiles au fur et à mesure des ajout des Tiles.
Sauf que maintenant je dois attendre la fin des ajouts de Tiles pour faire les liaisons.

Bon, je vois que l'exemple et mon input n'ont pas la même forme.
La solution que je vais ecrire ne sera surement pas compatible avec tout les inputs possible.

Un autre petit souci que je vois se profiler, c'est qu'une fois qu'on change de face sur le cube, les points cardinaux sont un peu chambouler.
Il va falloir y preter attention.