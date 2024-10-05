package ruby.ruby20244thquarteraddressableapi.domain.userInfo.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import ruby.ruby20244thquarteraddressableapi.domain.userInfo.entity.UserInfo
import ruby.ruby20244thquarteraddressableapi.domain.vendor.entity.Vendor

interface UserInfoRepository : JpaRepository<UserInfo, Long> {
    fun findByVendor(vendor: Vendor) : List<UserInfo>

    @Query("select u from UserInfo u " +
            "where u.id = :id " +
            "and u.vendor = :vendor " +
            "and u.deleted = false")
    fun findByIdAndVendor(id: Long, vendor: Vendor) : UserInfo?
}
