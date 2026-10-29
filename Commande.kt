class Commande(
    val numero: Int,
    val date: String,
    val client: Client,
    val produit: Produit,
    val quantite: Int
) {
    var statut: StatutCommande = StatutCommande.CREATED
        private set

    fun montantTotal(): Double {
        return produit.prixTTC() * quantite
    }
    fun payer(): Boolean {
        if (statut != StatutCommande.CREATED) {
            return false
        }
        if (quantite <= 0) {
            return false
        }
        if (!produit.retirerStock(quantite)) {
            return false
        }
        statut = StatutCommande.PAID
        return true
    }
    fun expedier(): Boolean {
        if (statut != StatutCommande.PAID) {
            return false
        }
        statut = StatutCommande.SHIPPED
        return true
    }
    fun annuler(): Boolean {
        if (statut == StatutCommande.SHIPPED) {
            return false
        }
        if (statut == StatutCommande.CANCELLED) {
            return false
        }
        if (statut == StatutCommande.PAID) {
            produit.ajouterStock(quantite)
        }
        statut = StatutCommande.CANCELLED
        return true
    }
    override fun toString(): String {
        return "Commande(numero=$numero, date=$date, client=${client.nom}, " +
            "produit=${produit.nom}, quantite=$quantite, statut=$statut)"
    }
}
