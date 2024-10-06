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
    val representativeUserInfo: RepresentativeUserInfo?,
    val supportingDocument: SupportingDocument?,
    val roleList: List<RoleCode> = listOf(),
    val userList: List<VendorUserInfo> = listOf()
) {
    data class RepresentativeUserInfo(
        val id: Long,
        val name: String
    )

    data class SupportingDocument(
        val id: Long,
        val originalFilename: String
    )

    data class VendorUserInfo(
        val id: Long,
        val userId: String,
        val name: String,
        val phoneNumber: String,
        val email: String,
        val useYn: Boolean,
        val deleted: Boolean,
    )
}
