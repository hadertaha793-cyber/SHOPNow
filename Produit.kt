abstract class Produit(
    val code: String,
    val nom: String,
    var prixHT: Double,
    stock: Int
) {
    var stock: Int = stock
        private set

    abstract fun prixTTC(): Double

    fun retirerStock(quantite: Int): Boolean {
        if (quantite <= 0 || quantite > stock) {
            return false
        }
        stock -= quantite
        return true
    }

    fun ajouterStock(quantite: Int) {
        if (quantite > 0) {
            stock += quantite
        }
    }
}
