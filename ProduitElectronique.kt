class ProduitElectronique(
    code: String,
    nom: String,
    prixHT: Double,
    stock: Int,
    val garantieMois: Int
) : Produit(code, nom, prixHT, stock), Remisable {

    override fun prixTTC(): Double {
        return prixHT * 1.20
    }

    override fun appliquerRemise(pourcentage: Double) {
        if (pourcentage in 0.0..100.0) {
            prixHT = prixHT * (1 - pourcentage / 100)
        }
    }
}
