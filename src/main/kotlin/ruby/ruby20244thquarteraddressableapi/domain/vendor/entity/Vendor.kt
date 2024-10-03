package ruby.ruby20244thquarteraddressableapi.domain.vendor.entity

import jakarta.persistence.*
import jakarta.persistence.FetchType.LAZY
import ruby.ruby20244thquarteraddressableapi.common.entity.BaseColumn
import ruby.ruby20244thquarteraddressableapi.domain.userInfo.entity.UserInfo

@Entity
class Vendor (
    @Column(nullable = false, unique = true)
    val companyNumber: String,
    @Column(nullable = false)
    val name: String,
    @Column(nullable = false)
    val contactNumber: String,
    @Column(nullable = false)
    val email: String,
    @Column(nullable = false)
    val useYn: Boolean,
    @Column(nullable = false)
    val deleted: Boolean,

) : BaseColumn() {
    @OneToMany(mappedBy = "vendorRoleId.vendor", cascade = [CascadeType.REMOVE])
    val roleList: MutableList<VendorRole> = mutableListOf()
    @OneToOne(fetch = LAZY)
    var representativeUserInfo: UserInfo? = null
    @OneToMany(mappedBy = "vendor", cascade = [CascadeType.REMOVE])
    val userList: MutableList<UserInfo> = mutableListOf()
}
