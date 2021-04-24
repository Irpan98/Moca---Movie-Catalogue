package id.itborneo.moca.core.utils.extension

val String?.toUnknownStringIfNull: String
    get() = this ?: "N?A"

val Int?.toUnknownIntIfNull: Int
    get() = this ?: 0

val Double?.toUnknownIntIfNull: Double
    get() = this ?: 0.0