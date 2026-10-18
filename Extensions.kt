fun String.isValidPhoneNumber(): Boolean {
    // Le + est suivi de 12 chiffres, sans espaces ni autres caractères.
    return Regex("^\\+[0-9]{12}$").matches(this)
}

fun Double.toDh(): String {
    return "$this dhs"
}
