package ruby.ruby20244thquarteraddressableapi.domain.userInfo.entity

import jakarta.persistence.*
import ruby.ruby20244thquarteraddressableapi.common.entity.BaseColumn
import ruby.ruby20244thquarteraddressableapi.domain.vendor.entity.Vendor

@Entity
class UserInfo(
    @Column(unique = true, nullable = false)
    val userId: String,
    @Column(nullable = false)
    val password: String,
    @Column(nullable = false)
    val name: String,
    @Column(unique = true, nullable = false)
    val phoneNumber: String,
    @Column(unique = true, nullable = false)
    val email: String,
    @Column(nullable = false)
    val useYn: Boolean,
    @Column(nullable = false)
    val deleted: Boolean,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendor_id")
    val vendor: Vendor
) : BaseColumn() {
    @OneToMany(mappedBy = "userRoleId.userInfo", fetch = FetchType.LAZY, cascade = [CascadeType.REMOVE])
    val userRoleList: MutableList<UserRole> = mutableListOf()
}
