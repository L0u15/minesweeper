# Projet d'algorithmie : Démineur
## 1. Questions générales
1. Donnez en quelques lignes, l’historique de l’arbre B. Et quelle est la signification de la lettre « B ».
> L'histoire de l'arbre B débute dans les années 1960 avec Rudolf Bayer et Ed McCreight. Dans leur papier de recherche *Organization and maintenance of large ordered indexes*, ils essayent des algorithmes pour trier et retrouver des informations sur des ordinateurs. La lettre "B" signifie "balancing" en anglais. On peut traduire cela par "arbre équilibré".

2. Est-ce que l’arbre-B est un arbre binaire ?
> Non. Les 2 sont des types de structures de données en arbre. L'arbre binaire est une structure de données qui a au plus 2 fils. 
3. Est-ce que l’arbre-B est un arbre équilibré ?
> Oui. L'arbre-B est un arbre équilibré.
4. Est-ce que l’arbre B grandit à partir de la racine ou à partir des feuilles ?
> L'insertion commence par des feuilles. Ensuite, l'algorithme d'insertion va remanier l'arbre pour le garder équilibré.
5. A quoi servent les arbres B ?
6. Quelle est la différence entre l’arbre B et l’arbre B+ ?

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
