package ruby.ruby20244thquarteraddressableapi.domain.vendor.repository

import org.springframework.data.jpa.repository.JpaRepository
import ruby.ruby20244thquarteraddressableapi.domain.vendor.entity.Vendor

interface VendorRepository : JpaRepository<Vendor, Long>
