package ruby.ruby20244thquarteraddressableapi.domain.vendor.dto.request

import jakarta.validation.Valid
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern

data class VendorPost(
    @field:Pattern(regexp = "\\d{10}", message = "{company-number.pattern}")
    @field:NotBlank(message = "{company-number.empty}")
    val companyNumber: String,
    @field:NotBlank(message = "{vendor-name.empty}")
    val name: String,
    @field:Pattern(regexp = "\\d{11}", message = "{phone.pattern}")
    @field:NotBlank(message = "{phone.empty}")
    val contactNumber: String,
    @field:Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "{email.pattern}")
    @field:NotBlank(message = "{email.empty}")
    val email: String,
    val roleList: List<String> = listOf(),
    @field:Valid
    val representativeUserInfo: RepresentativeUserInfo
) {
    data class RepresentativeUserInfo(
        @field:NotBlank(message = "{id.empty}")
        val userId: String,
        @field:Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d).{8,}\$", message = "{password.pattern}")
        @field:NotBlank(message = "{password.empty}")
        val password: String,
        @field:NotBlank(message = "{user-name.empty}")
        val name: String,
        @field:Pattern(regexp = "\\d{11}", message = "{phone.pattern}")
        @field:NotBlank(message = "{phone.empty}")
        val phoneNumber: String,
        @field:Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "{email.pattern}")
        @field:NotBlank(message = "{email.empty}")
        val email: String
    )
}
