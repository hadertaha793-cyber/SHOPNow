class ProduitAlimentaire(
    code: String,
    nom: String,
    prixHT: Double,
    stockInitial: Int,
    val dateLimite: String
) : Produit(code, nom, prixHT, stockInitial) {

    override fun prixTTC(): Double {
        return prixHT * 1.10
    }
}
