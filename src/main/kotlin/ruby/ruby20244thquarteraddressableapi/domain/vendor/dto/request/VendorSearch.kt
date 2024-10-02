package ruby.ruby20244thquarteraddressableapi.domain.vendor.dto.request

data class VendorSearch(
    val search: String? = "",
    val page: Int? = 0,
    val pageSize: Int? = 10
)
