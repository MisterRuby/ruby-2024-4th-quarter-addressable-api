package ruby.ruby20244thquarteraddressableapi.domain.vendor.dto.request

data class VendorPost(
    val companyNumber: String,
    val name: String,
    val contactNumber: String,
    val email: String,
    val roleList: List<String> = listOf(),
    val representativeUserInfo: RepresentativeUserInfo
) {
    data class RepresentativeUserInfo(
        val userId: String,
        val password: String,
        val name: String,
        val phoneNumber: String,
        val email: String
    )
}
