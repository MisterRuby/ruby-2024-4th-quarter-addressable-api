package ruby.ruby20244thquarteraddressableapi.domain.userInfo.repository

import org.springframework.data.jpa.repository.JpaRepository
import ruby.ruby20244thquarteraddressableapi.domain.userInfo.entity.UserInfo
import ruby.ruby20244thquarteraddressableapi.domain.vendor.entity.Vendor

interface UserInfoRepository : JpaRepository<UserInfo, Long> {
    fun findByVendor(vendor: Vendor) : List<UserInfo>
}
