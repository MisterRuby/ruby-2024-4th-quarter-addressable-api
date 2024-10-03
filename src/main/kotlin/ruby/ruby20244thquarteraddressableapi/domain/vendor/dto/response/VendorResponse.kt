package ruby.ruby20244thquarteraddressableapi.domain.vendor.dto.response

import ruby.ruby20244thquarteraddressableapi.domain.vendor.entity.VendorRole

data class VendorResponse(
    val id: Long,
    val companyNumber: String,
    val name: String,
    val contactNumber: String,
    val email: String,
    val useYn: Boolean,
    val deleted: Boolean,
    val representativeUsername: String?
)
