package ruby.ruby20244thquarteraddressableapi.domain.vendor.entity

import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import ruby.ruby20244thquarteraddressableapi.domain.vendor.entity.embedded.VendorRoleId

@Entity
class VendorRole (
    @EmbeddedId
    val vendorRoleId: VendorRoleId
)
