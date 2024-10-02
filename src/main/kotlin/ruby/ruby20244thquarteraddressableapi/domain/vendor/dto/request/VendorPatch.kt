package ruby.ruby20244thquarteraddressableapi.domain.vendor.dto.request

import ruby.ruby20244thquarteraddressableapi.domain.vendor.entity.VendorRole

data class VendorPatch(
    val name: String?,
    val contactNumber: String?,
    val email: String?,
    val useYn: Boolean?,
    val vendorRoleList: MutableList<VendorRole> = mutableListOf(),
    var representativeUserId: Long,
)
