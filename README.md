# Projet PCL

## Introduction

L'objectif de ce projet est de réaliser la première partie  d'un compilateur du langage tiger avec la partie analyse lexicale, syntaxique , AST et analyse sémantique.


## Utilisation du compilateur

Un Makefile est fourni afin de simplifier l'utilisation du projet. Voici les commandes disponibles :
#### 1 - Make parser

Cette commande permet de créer les classes associées au parser .

#### 2 - Make compile

Cette commande permet de compiler le projet.

#### 3 - Make run

Cette commande permet de run le projet compilé , elle prend en argument le chemin vers le fichier à compiler.

#### 4 - Make all

Cette commande permet de faire les étapes 1,2 et 3 en une seule commande.

Exemple en étant à la racine du projet : `make all target=examples/testsyntaxique/reussi/conditions4.tiger`

#### 5 - Make image

Cette commande permet de créer l'image de l'AST créee par le compilateur. Vous pouvez la trouver dans le répertoire out sous le nom de tree.svg