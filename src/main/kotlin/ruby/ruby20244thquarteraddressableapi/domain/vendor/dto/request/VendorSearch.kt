package ruby.ruby20244thquarteraddressableapi.domain.vendor.dto.request

import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min

data class VendorSearch(
    val search: String = "",
    @field:Min(1, message = "{page.min}")
    val page: Int,
    @field:Min(10, message = "{page-size.min}")
    @field:Max(100, message = "{page-size.max}")
    val pageSize: Int
)
