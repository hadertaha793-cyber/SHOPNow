fun String.isValidPhoneNumber(): Boolean {
    val formatTelephone = Regex("^\\+[0-9]{12}$")
    return formatTelephone.matches(this)
}

fun Double.toDh(): String {
    return "$this dhs"
}

