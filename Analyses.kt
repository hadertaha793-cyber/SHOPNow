fun commandesDuClient(commandes: List<Commande>, client: String): List<Commande> =
    commandes.filter { it.client.nom == client }

fun totalPayees(commandes: List<Commande>): Double =
    commandes.filter { it.statut == StatutCommande.PAID }
        .sumOf { it.montantTotal() }

fun totalAnnulees(commandes: List<Commande>): Double =
    commandes.filter { it.statut == StatutCommande.CANCELLED }
        .sumOf { it.montantTotal() }

fun estPayee(commande: Commande): Boolean =
    commande.statut == StatutCommande.PAID

fun filtrerCommandes(
    commandes: List<Commande>,
    critere: (Commande) -> Boolean
): List<Commande> = commandes.filter(critere)

//  les statuts et montants correspondent au tableau de référence.
fun jeuDeDonnees(): List<Commande> {
    val amine = Client(1, "Amine", "Safi")
    val sara = Client(2, "Sara", "Marrakech")
    val hicham = Client(3, "Hicham", "Rabat")
    val rania = Client(4, "Rania", "Agadir")

    val laptop = ProduitElectronique("E1", "Laptop", 5000.0, 100, 24)
    val telephone = ProduitElectronique("E2", "Phone", 2000.0, 100, 12)
    val riz = ProduitAlimentaire("A1", "Riz", 20.0, 1000, "2027-01-01")
    val lait = ProduitAlimentaire("A2", "Lait", 10.0, 500, "2026-12-01")

    val c1 = Commande(1, "2026-10-01", amine, laptop, 1).also { it.payer() }
    val c2 = Commande(2, "2026-10-02", sara, telephone, 1).also { it.payer() }
    val c3 = Commande(3, "2026-10-03", amine, riz, 10).also { it.payer() }

    val c4 = Commande(4, "2026-10-04", hicham, laptop, 2)
    c4.payer()
    c4.annuler()

    val c5 = Commande(5, "2026-10-05", sara, lait, 20) // reste CREATED

    val c6 = Commande(6, "2026-10-06", rania, telephone, 3).also { it.payer() }

    val c7 = Commande(7, "2026-10-07", amine, lait, 10)
    c7.annuler()

    val c8 = Commande(8, "2026-10-08", hicham, riz, 100).also { it.payer() }

    return listOf(c1, c2, c3, c4, c5, c6, c7, c8)
}

//  écrit une ligne par commande du client dans Client<id>.txt.
fun ecrireHistorique(client: Client, commandes: List<Commande>) {
    val contenu = commandes
        .filter { it.client.id == client.id }
        .joinToString(separator = "\n") { commande ->
            "Numero=${commande.numero}; Date=${commande.date}; " +
                "Produit=${commande.produit.nom}; Quantite=${commande.quantite}; " +
                "Montant=${commande.montantTotal()}; Statut=${commande.statut}"
        }

    java.io.File("Client${client.id}.txt").writeText(contenu)
}
