abstract class Produit(
    val code: String,
    val nom: String,
    var prixHT: Double,
    stockInitial: Int
) {
   var stock: Int = stockInitial
        private set

    abstract fun prixTTC(): Double

    fun retirerStock(quantite: Int): Boolean {
        if (quantite <= 0) {
            return false
        }
        if (quantite > stock) {
            return false
        }

        stock = stock - quantite
        return true
    }
    fun ajouterStock(quantite: Int) {
        if (quantite > 0) {
            stock = stock + quantite
        }
    }
}
