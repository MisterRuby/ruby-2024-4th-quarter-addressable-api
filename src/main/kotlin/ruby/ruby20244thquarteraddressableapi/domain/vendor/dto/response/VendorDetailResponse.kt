package ruby.ruby20244thquarteraddressableapi.domain.vendor.dto.response

import ruby.ruby20244thquarteraddressableapi.common.code.RoleCode

data class VendorDetailResponse(
    val id: Long,
    val companyNumber: String,
    val name: String,
    val contactNumber: String,
    val email: String,
    val useYn: Boolean,
    val deleted: Boolean,
    val representativeUsername: String?,
    val roleList: List<RoleCode> = listOf(),
    val userList: List<VendorUserInfo> = listOf()
) {
    class VendorUserInfo(
        val id: Long,
        val userId: String,
        val name: String,
        val phoneNumber: String,
        val email: String,
        val useYn: Boolean,
        val deleted: Boolean,
    )
}
