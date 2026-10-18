fun main() {
    println("=== 1. Products and VAT ===")
    val laptop = ProduitElectronique("E1", "Laptop", 5000.0, 10, 24)
    val riz = ProduitAlimentaire("A1", "Riz", 20.0, 100, "2027-01-01")
    println("${laptop.nom}: ${laptop.prixTTC()} dhs") // 6000.0
    println("${riz.nom}: ${riz.prixTTC()} dhs")       // 22.0

    println("\\n=== 2. Discount and stock ===")
    laptop.appliquerRemise(10.0)
    println("Laptop HT after 10% discount: ${laptop.prixHT}") // 4500.0
    println("Laptop TTC: ${laptop.prixTTC()}")                // 5400.0
    println("Remove 3: ${laptop.retirerStock(3)}")            // true
    println("Stock: ${laptop.stock}")                         // 7
    println("Remove 50: ${laptop.retirerStock(50)}")          // false
    laptop.ajouterStock(3)
    println("Stock after adding 3: ${laptop.stock}")           // 10

    println("\\n=== 3. Orders ===")
    val sara = Client(2, "Sara", "Marrakech")
    val order = Commande(101, "2026-10-10", sara, laptop, 2)
    println("Initial status: ${order.statut}")                // CREATED
    println("Total: ${order.montantTotal()}")                 // 10800.0
    println("Pay: ${order.payer()}")                          // true
    println("Status: ${order.statut}")                        // PAID
    println("Stock: ${laptop.stock}")                         // 8
    println("Ship: ${order.expedier()}")                      // true
    println("Cancel shipped order: ${order.annuler()}")       // false

    println("\\n=== 4. Boutique ===")
    val boutique = Boutique()
    println(boutique.ajouter(laptop))                         // true
    println(boutique.ajouter(riz))                            // true
    println(boutique.ajouter(laptop))                         // false duplicate code
    println("Electronic products: ${boutique.nombreProduitsElectroniques()}") // 1
    println("Index of A1: ${boutique.indiceProduit("A1")}")   // 1

    println("\\n=== 5. Collection functions ===")
    val commandes = jeuDeDonnees()
    commandes.forEach { println("${it.client.nom} : ${it.montantTotal()}") }
    val montants = commandes.map { it.montantTotal() }
    println("Amounts: $montants")
    println("Orders above 1000: ${commandes.filter { it.montantTotal() > 1000 }.map { it.numero }}")
    println("Any cancelled: ${commandes.any { it.statut == "CANCELLED" }}")
    println("All paid: ${commandes.all { it.statut == "PAID" }}")
    println("Paid sales in Safi: ${
        commandes.filter { it.statut == "PAID" && it.client.ville == "Safi" }
            .sumOf { it.montantTotal() }
    }")
    println("Largest paid order: ${
        commandes.filter { it.statut == "PAID" }
            .maxByOrNull { it.montantTotal() }?.client?.nom
    }")
    println("Clients with cancelled orders: ${
        commandes.filter { it.statut == "CANCELLED" }
            .map { it.client.nom }.distinct()
    }")
    println("Top 3 paid orders: ${
        commandes.filter { it.statut == "PAID" }
            .sortedByDescending { it.montantTotal() }
            .take(3)
            .map { "${it.client.nom}: ${it.montantTotal()}" }
    }")
    println("Paid sales by city: ${
        commandes.filter { it.statut == "PAID" }
            .groupBy { it.client.ville }
            .mapValues { (_, liste) -> liste.sumOf { it.montantTotal() } }
    }")
    println("Paid total: ${totalPayees(commandes)}")
    println("Cancelled total: ${totalAnnulees(commandes)}")
    println("Amine orders: ${commandesDuClient(commandes, "Amine").map { it.numero }}")

    println("\\n=== 6. Extensions and lambdas ===")
    println("+212600000000".isValidPhoneNumber()) // true
    println("0600000000".isValidPhoneNumber())   // false
    println(1200.0.toDh())                      // 1200.0 dhs

    val bigOrders = filtrerCommandes(commandes) { c -> c.montantTotal() > 1000 }
    val safiOrders = filtrerCommandes(commandes) { it.client.ville == "Safi" }
    val paidOrders = filtrerCommandes(commandes, ::estPayee)
    println("Orders above 1000: ${bigOrders.size}") // 5
    println("Orders for Safi: ${safiOrders.size}")  // 3
    println("Paid orders: ${paidOrders.size}")      // 5
}
