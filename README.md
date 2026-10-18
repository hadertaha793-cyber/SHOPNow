# ShopNow Kotlin TP

**ShopNow** est un projet pédagogique réalisé en Kotlin dans le cadre d'un TP de programmation orientée objet. Il consiste à créer une petite application de gestion de boutique en ligne.

Le projet permet de manipuler des produits, des clients et des commandes, tout en mettant en pratique les bases de Kotlin et de la programmation orientée objet.

## Fonctionnalités

- Gestion des produits et du stock.
- Différents types de produits : électroniques et alimentaires.
- Calcul des prix TTC et application de remises.
- Gestion des clients et des commandes.
- Suivi du paiement et de l'expédition des commandes.
- Recherche, filtrage et analyse des données.
- Formatage des montants en dirhams (DH).

## Structure du projet

| Fichier | Description |
|---|---|
| `Produit.kt` | Classe abstraite qui représente un produit. |
| `ProduitElectronique.kt` | Gestion des produits électroniques, de la TVA et de la garantie. |
| `ProduitAlimentaire.kt` | Gestion des produits alimentaires et de leur date limite. |
| `Remisable.kt` | Interface pour les produits pouvant bénéficier d'une remise. |
| `Client.kt` | Représentation d'un client avec une `data class`. |
| `Commande.kt` | Gestion des commandes et de leurs opérations. |
| `Boutique.kt` | Gestion du catalogue de produits. |
| `Analyses.kt` | Fonctions permettant d'analyser les données avec les collections Kotlin. |
| `Extensions.kt` | Fonctions d'extension pour la validation et le formatage. |
| `Main.kt` | Point d'entrée du programme et scénario de démonstration. |

## Concepts Kotlin utilisés

- **Programmation orientée objet** : classes, objets, héritage et polymorphisme.
- **Classes abstraites et interfaces** : partager des comportements entre plusieurs classes.
- **Encapsulation** : utiliser `private set`, `val` et `var`.
- **Redéfinition de méthodes** : utiliser `override`.
- **Data classes** : représenter simplement les données d'un client.
- **Collections** : utiliser `filter`, `map`, `forEach`, `groupBy`, `sumOf` et d'autres fonctions.
- **Lambdas** : écrire des fonctions courtes pour traiter des données.
- **Fonctions d'extension** : ajouter des fonctionnalités à des classes existantes.

