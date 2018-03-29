# Projet d'algorithmie : Démineur
## 1. Questions générales
1. Auteur algo (Will)
2. L'histoire de l'arbre-B
> L'histoire de l'arbre B débute dans les années 1960 1970 avec **Rudolf Bayer** et **Edward Meyers McCreight**. Dans son papier de recherche *Binary B-Trees for Virtual Memory*, Rudolf Bayer  décrit une classe d’arbre binaire maintenant un ensemble de données ordonnées. L’insertion, la suppression et la recherche de clef peut être faite avec une complexité de **O(log n)** ou n est la cardinalité de l’ensemble des données.
En 1972, Bayer et Meyers publient *Organization and Maintenance of Large Ordered Indexes*. Ils y présent de nouveaux algorithmes de tri et de recherche d’informations sur ordinateurs, ainsi que leurs performances. Ces algorithmes étaient basés sur la structure de données arbre-B.
Depuis les arbre-B sont utilisées notamment par les bases de données et les systèmes de fichiers (HFS+,NTFS, btrfs).


## 2. Récursivité : évaluation de la complexité
1. Placement des nombres sur le plateau
- Pour l'exercice, nous avons placé les nombres sur le plateau en utilisant un algorithme récursif:

Après avoir placé les mines aléatoirement. En partant de la case au centre du plateau,
```
Placer les nombres de manière récursive :
    Si la case est vide
        Compter le nombre de mines présentes dans les 8 cases adjacentes
        Instancier la case avec ce nombre
        Pour les 8 cases adjacentes
            Placer les nombres de manière récursive
    Fin Si
```
Cet algorithme a une complexité de **O(H*L)**

- Pour comparer, nous avons imaginé un autre algorithme non récursif :

Après avoir placé les mines aléatoirement et gardé leurs positions dans une liste O(M)
```
Pour chaque position de la liste:
    Pour les 8 cases adjacentes:
        Si la case n'est pas une mine
            Si la case est vide -> devient un ZERO
            On incrémente la valeur du numéro
```
Cet algorithme a une complexité de **O(M)**

Comme M sera toujours inferieur à H*L ( il ne peut pas y avoir plus de mines que de cases sur le plateau), l'algorithme non récursif est plus optimisé.

2. Fonctionalité UNDO et REDO
Dans notre jeu, nous pouvons revenir en arrière et repartir vers la dernière action faite. Cette fonctionalité repose sur une **liste doublement chainée** (class `Action.java`).
