class Boutique {
    private val produits = mutableListOf<Produit>()

    fun indiceProduit(code: String): Int {
        return produits.indexOfFirst { it.code == code }
    }

    fun ajouter(p: Produit): Boolean {
        if (indiceProduit(p.code) != -1) {
            return false
        }
        produits.add(p)
        return true
    }

    fun supprimer(code: String): Boolean {
        val index = indiceProduit(code)
        if (index == -1) {
            return false
        }
        produits.removeAt(index)
        return true
    }

    fun supprimer(p: Produit): Boolean {
        return supprimer(p.code)
    }

    fun nombreProduitsElectroniques(): Int {
        return produits.count { it is ProduitElectronique }
    }

    fun listerProduits(): List<Produit> {
        return produits.toList()
    }
}
