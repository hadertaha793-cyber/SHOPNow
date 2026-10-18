# ShopNow Kotlin TP

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

## Notions couvertes

- Classes, objets, héritage et classe abstraite
- `override` et polymorphisme
- `val`, `var`, encapsulation et `private set`
- `data class`
- Interface (`Remisable`)
- Collections : `forEach`, `map`, `filter`, `sortedByDescending`, `take`, `any`, `all`, `sumOf`, `maxByOrNull`, `distinct`, `groupBy`, `mapValues`
- Fonctions d'extension
- Lambdas et référence de fonction (`::estPayee`)


