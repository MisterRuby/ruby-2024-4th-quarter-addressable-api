package ruby.ruby20244thquarteraddressableapi.domain.vendor.dto.request

data class VendorPatch(
    val name: String?,
    val contactNumber: String?,
    val email: String?,
    val useYn: Boolean?,
    var deleted: Boolean?,
    val roleList: List<String>?,
    val representativeUserId: Long?,
)
