class ProduitElectronique(
    code: String,
    nom: String,
    prixHT: Double,
    stockInitial: Int,
    val garantieMois: Int
) : Produit(code, nom, prixHT, stockInitial), Remisable {

    override fun prixTTC(): Double = prixHT * 1.20

    override fun appliquerRemise(pourcentage: Double) {
        if (pourcentage in 0.0..100.0) {
            prixHT *= 1 - pourcentage / 100
        }
    }
}
