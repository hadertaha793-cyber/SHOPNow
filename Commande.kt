class Commande(
    val numero: Int,
    val date: String,
    val client: Client,
    val produit: Produit,
    val quantite: Int
) {
    var statut: String = "CREATED"
        private set

    fun montantTotal(): Double {
        return produit.prixTTC() * quantite
    }

    fun payer(): Boolean {
        if (statut != "CREATED" || quantite <= 0) {
            return false
        }

        if (!produit.retirerStock(quantite)) {
            return false
        }

        statut = "PAID"
        return true
    }

    fun expedier(): Boolean {
        if (statut != "PAID") {
            return false
        }

        statut = "SHIPPED"
        return true
    }

    fun annuler(): Boolean {
        if (statut == "SHIPPED" || statut == "CANCELLED") {
            return false
        }

        if (statut == "PAID") {
            produit.ajouterStock(quantite)
        }

        statut = "CANCELLED"
        return true
    }
}
