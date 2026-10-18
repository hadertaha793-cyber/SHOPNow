# ShopNow — Kotlin TP

Projet pédagogique simple pour le TP de gestion de boutique en ligne ShopNow.

## Fichiers

- `Produit.kt` : classe abstraite, prix HT, stock protégé.
- `ProduitElectronique.kt` : TVA 20 %, garantie et remise.
- `ProduitAlimentaire.kt` : TVA 10 % et date limite.
- `Remisable.kt` : interface bonus pour les produits remisable.
- `Client.kt` : data class client.
- `Commande.kt` : montant, paiement, expédition et annulation.
- `Boutique.kt` : catalogue de produits, ajout et suppression.
- `Analyses.kt` : jeu de données et fonctions d'analyse avec collections.
- `Extensions.kt` : validation de numéro et formatage en dhs.
- `Main.kt` : scénario de démonstration.

## Comment l'utiliser

1. Dans Android Studio, crée un projet **Kotlin/JVM** (console) pour lancer directement `main()`.
2. Place tous les fichiers `.kt` dans le même dossier source/package.
3. Si tu utilises un `package` en haut de tes fichiers, mets le même package dans chaque fichier.
4. Lance `Main.kt`.

Un projet Android standard n'exécute pas forcément une fonction `main()` comme une application console. Pour ce dossier de TP, un projet Kotlin/JVM est le choix le plus simple.

## Notions couvertes

- Classes, objets, héritage et classe abstraite
- `override` et polymorphisme
- `val`, `var`, encapsulation et `private set`
- `data class`
- Interface (`Remisable`)
- Collections : `forEach`, `map`, `filter`, `sortedByDescending`, `take`, `any`, `all`, `sumOf`, `maxByOrNull`, `distinct`, `groupBy`, `mapValues`
- Fonctions d'extension
- Lambdas et référence de fonction (`::estPayee`)

## Avant de rendre le TP

- Lis et comprends chaque méthode : le professeur peut demander de l'expliquer.
- Exécute les tests et prends des captures d'écran de la console pour le dépôt GitHub.
- Le bonus `enum class StatutCommande` et l'écriture de l'historique dans un fichier ne sont pas inclus dans cette version de base.
- Le code suit les signatures imposées dans le PDF pour les classes principales. La classe `Commande` utilise le statut `String` comme demandé dans la partie obligatoire.
