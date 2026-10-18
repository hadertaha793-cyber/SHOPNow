fun String.isValidPhoneNumber(): Boolean {
    return Regex("^\\+[0-9]{12}$").matches(this)
}

fun Double.toDh(): String {
    return "$this dhs"
}
