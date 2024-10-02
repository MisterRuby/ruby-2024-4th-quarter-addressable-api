package ruby.ruby20244thquarteraddressableapi.domain.vendor.entity.embedded

import jakarta.persistence.*
import ruby.ruby20244thquarteraddressableapi.common.code.RoleCode
import ruby.ruby20244thquarteraddressableapi.domain.vendor.entity.Vendor
import java.io.Serializable

@Embeddable
data class VendorRoleId (
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendor_id")
    val vendor: Vendor,
    @Enumerated(EnumType.STRING)
    val roleCode: RoleCode
) : Serializable
