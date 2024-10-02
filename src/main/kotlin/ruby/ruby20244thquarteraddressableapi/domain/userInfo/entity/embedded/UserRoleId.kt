package ruby.ruby20244thquarteraddressableapi.domain.userInfo.entity.embedded

import jakarta.persistence.*
import ruby.ruby20244thquarteraddressableapi.domain.userInfo.entity.UserInfo
import ruby.ruby20244thquarteraddressableapi.common.code.RoleCode
import java.io.Serializable

@Embeddable
data class UserRoleId(
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_info_id")
    val userInfo: UserInfo,
    @Enumerated(EnumType.STRING)
    val roleCode: RoleCode
) : Serializable
