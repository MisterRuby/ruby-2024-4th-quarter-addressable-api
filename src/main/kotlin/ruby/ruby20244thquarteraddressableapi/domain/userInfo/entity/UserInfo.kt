package ruby.ruby20244thquarteraddressableapi.domain.userInfo.entity

import jakarta.persistence.*
import ruby.ruby20244thquarteraddressableapi.common.entity.BaseColumn
import ruby.ruby20244thquarteraddressableapi.domain.vendor.entity.Vendor

@Entity
class UserInfo(
    @Column(unique = true, nullable = false)
    val userId: String,
    @Column(nullable = false)
    var password: String,
    @Column(nullable = false)
    var name: String,
    @Column(unique = true, nullable = false)
    var phoneNumber: String,
    @Column(unique = true, nullable = false)
    var email: String,
    @Column(nullable = false)
    var useYn: Boolean,
    @Column(nullable = false)
    var deleted: Boolean,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendor_id")
    val vendor: Vendor
) : BaseColumn() {
    @OneToMany(mappedBy = "userRoleId.userInfo", fetch = FetchType.LAZY, cascade = [CascadeType.REMOVE])
    val userRoleList: MutableList<UserRole> = mutableListOf()
}
