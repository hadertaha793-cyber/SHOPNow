fun String.isValidPhoneNumber(): Boolean =
    Regex("^\\+[0-9]{12}$").matches(this)

fun Double.toDh(): String = "$this dhs"
