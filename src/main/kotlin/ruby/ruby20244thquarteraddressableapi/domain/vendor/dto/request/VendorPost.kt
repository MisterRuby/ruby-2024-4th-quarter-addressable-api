package ruby.ruby20244thquarteraddressableapi.domain.vendor.dto.request

import ruby.ruby20244thquarteraddressableapi.domain.vendor.entity.VendorRole

data class VendorPost(
    val companyNumber: String,
    val name: String,
    val contactNumber: String,
    val email: String,
    val vendorRoleList: MutableList<VendorRole> = mutableListOf()
)
