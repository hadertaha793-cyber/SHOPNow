fun main() {
    //  produits, TVA, remise et stock
    println("\n1. PRODUITS, TVA ET STOCK")
    val laptop = ProduitElectronique("E1", "Laptop", 5000.0, 10, 24)
    val riz = ProduitAlimentaire("A1", "Riz", 20.0, 100, "2027-01-01")
    val lait = ProduitAlimentaire("A2", "Lait", 10.0, 50, "2026-12-01")
    val casque = ProduitElectronique("E3", "Casque", 300.0, 5, 12)

    println("Laptop TTC : ${laptop.prixTTC()}") // 6000.0
    println("Riz TTC : ${riz.prixTTC()}")       // 22.0
    laptop.appliquerRemise(10.0)
    println("Laptop HT après remise : ${laptop.prixHT}") // 4500.0
    println("Laptop TTC après remise : ${laptop.prixTTC()}") // 5400.0
    println("Retirer 3 laptops : ${laptop.retirerStock(3)}") // true
    println("Stock : ${laptop.stock}") // 7
    println("Retirer 50 laptops : ${laptop.retirerStock(50)}") // false
    println("Stock inchangé : ${laptop.stock}") // 7
    laptop.ajouterStock(3)
    println("Stock après ajout : ${laptop.stock}") // 10

    //  test du cycle de vie des commandes
    println("\n2. COMMANDES ET STATUTS")
    val sara = Client(2, "Sara", "Marrakech")
    val amine = Client(1, "Amine", "Safi")
    val hicham = Client(3, "Hicham", "Rabat")

    val c1 = Commande(101, "2026-10-10", sara, laptop, 2)
    println("Statut initial : ${c1.statut}") // CREATED
    println("Montant : ${c1.montantTotal()}") // 10800.0
    println("Paiement réussi : ${c1.payer()}") // true
    println("Statut : ${c1.statut}") // PAID
    println("Stock après paiement : ${laptop.stock}") // 8
    println("Deuxième paiement refusé : ${c1.payer()}") // false
    println("Expédition : ${c1.expedier()}") // true
    println("Annulation après expédition refusée : ${c1.annuler()}") // false

    val c2 = Commande(102, "2026-10-11", amine, laptop, 20)
    println("Paiement avec stock insuffisant : ${c2.payer()}") // false
    println("Statut inchangé : ${c2.statut}") // CREATED
    println("Stock inchangé : ${laptop.stock}") // 8

    val c3 = Commande(103, "2026-10-12", hicham, laptop, 3)
    println("Paiement c3 : ${c3.payer()}") // true
    println("Stock avant annulation : ${laptop.stock}") // 5
    println("Annulation avec restitution : ${c3.annuler()}") // true
    println("Stock après restitution : ${laptop.stock}") // 8
    println("Statut c3 : ${c3.statut}") // CANCELLED

    val c4 = Commande(104, "2026-10-13", sara, riz, 1)
    val c5 = Commande(105, "2026-10-14", amine, lait, 2)
    val c6 = Commande(106, "2026-10-15", hicham, casque, 1)
    println("Annulation sans paiement : ${c4.annuler()}") // true
    println("Paiement c5 : ${c5.payer()}") // true
    println("Expédition c5 : ${c5.expedier()}") // true
    println("Paiement c6 : ${c6.payer()}") // true
    println("Les 6 commandes : ${listOf(c1, c2, c3, c4, c5, c6).map { it.statut }}")

    // enum
    println("Nombre de statuts possibles : ${StatutCommande.values().size}") // 4
    println("Le statut de c1 est SHIPPED : ${c1.statut == StatutCommande.SHIPPED}") // true

    // Boutique
    println("\n3. BOUTIQUE")
    val boutique = Boutique()
    println("Ajouter laptop : ${boutique.ajouter(laptop)}") // true
    println("Ajouter le même code : ${boutique.ajouter(laptop)}") // false
    println("Ajouter riz : ${boutique.ajouter(riz)}") // true
    println("Ajouter casque : ${boutique.ajouter(casque)}") // true
    println("Index A1 : ${boutique.indiceProduit("A1")}") // 1
    println("Index absent : ${boutique.indiceProduit("ZZ")}") // -1
    println("Produits électroniques : ${boutique.nombreProduitsElectroniques()}") // 2
    println("Supprimer A1 : ${boutique.supprimer("A1")}") // true
    println("Supprimer A1 une seconde fois : ${boutique.supprimer("A1")}") // false
    println("Supprimer le laptop : ${boutique.supprimer(laptop)}") // true
    println("Index E3 : ${boutique.indiceProduit("E3")}") // 0

    //   sans for/while.
    
    val commandes = jeuDeDonnees()

    println("Q1 - Clients et montants :")
    commandes.forEach { println("${it.client.nom} : ${it.montantTotal()}") }

    println("Q2 - Montants : ${commandes.map { it.montantTotal() }}")
    println("Q3 - Commandes > 1000 : ${commandes.filter { it.montantTotal() > 1000 }.map { it.numero }}")
    println("Q4 - Ordre croissant : ${commandes.sortedBy { it.montantTotal() }.map { it.numero }}")
    println("Q4 - Ordre décroissant : ${commandes.sortedByDescending { it.montantTotal() }.map { it.numero }}")
    println("Q5 - Au moins une annulée : ${commandes.any { it.statut == StatutCommande.CANCELLED }}")
    println("Q5 - Toutes payées : ${commandes.all { it.statut == StatutCommande.PAID }}")
    println("Q6 - Ventes payées à Safi : ${
        commandes.filter { it.statut == StatutCommande.PAID && it.client.ville == "Safi" }
            .sumOf { it.montantTotal() }
    }")
    println("Q7 - Plus grosse commande payée : ${
        commandes.filter { it.statut == StatutCommande.PAID }
            .maxByOrNull { it.montantTotal() }?.client?.nom
    }")
    println("Q8 - Clients avec commandes annulées : ${
        commandes.filter { it.statut == StatutCommande.CANCELLED }
            .map { it.client.nom }.distinct()
    }")
    println("Q9 - Top 3 payées : ${
        commandes.filter { it.statut == StatutCommande.PAID }
            .sortedByDescending { it.montantTotal() }
            .take(3).map { "${it.client.nom} : ${it.montantTotal()}" }
    }")
    println("Q10 - Ventes payées par ville : ${
        commandes.filter { it.statut == StatutCommande.PAID }
            .groupBy { it.client.ville }
            .mapValues { (_, liste) -> liste.sumOf { it.montantTotal() } }
    }")
    println("Q11 - Commandes Amine : ${commandesDuClient(commandes, "Amine").map { it.numero }}")
    println("Q11 - Total payé : ${totalPayees(commandes)}")
    println("Q11 - Total annulé : ${totalAnnulees(commandes)}")

    //  extensions et fonctions d'ordre supérieur
    println("\n5. EXTENSIONS ET LAMBDAS")
    println("Téléphone valide : ${"+212600000000".isValidPhoneNumber()}") // true
    println("Téléphone sans + : ${"0600000000".isValidPhoneNumber()}") // false
    println("Téléphone avec espaces : ${"+212 600 000 000".isValidPhoneNumber()}") // false
    println("Téléphone trop court : ${"+21260000000".isValidPhoneNumber()}") // false
    println("Téléphone trop long : ${"+2126000000001".isValidPhoneNumber()}") // false
    println("Montant : ${1200.0.toDh()}") // 1200.0 dhs

    println("Lambda complète : ${filtrerCommandes(commandes) { c -> c.montantTotal() > 1000 }.size}") // 5
    println("Lambda avec it : ${filtrerCommandes(commandes) { it.client.ville == "Safi" }.size}") // 3
    println("Référence ::estPayee : ${filtrerCommandes(commandes, ::estPayee).size}") // 5

    //  historique dans un fichier texte.
    ecrireHistorique(sara, commandes)
    println("Historique écrit dans Client${sara.id}.txt")
}
