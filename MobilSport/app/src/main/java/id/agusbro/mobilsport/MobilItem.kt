package id.agusbro.mobilsport

data class MobilItem(
    var Name: String = "",
    var SubName: String = "",
    var Image: Int = 0,
    var Harga: Float = 0.0F,
    var Details: String = "",
    var Spek: Array<String> = arrayOf()
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MobilItem

        if (Name != other.Name) return false
        if (SubName != other.SubName) return false
        if (Image != other.Image) return false
        if (Harga != other.Harga) return false
        if (Details != other.Details) return false
        if (!Spek.contentEquals(other.Spek)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = Name.hashCode()
        result = 31 * result + SubName.hashCode()
        result = 31 * result + Image
        result = 31 * result + Harga.hashCode()
        result = 31 * result + Details.hashCode()
        result = 31 * result + Spek.contentHashCode()
        return result
    }
}