package ruby.ruby20244thquarteraddressableapi.domain.userInfo.entity

import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import ruby.ruby20244thquarteraddressableapi.domain.userInfo.entity.embedded.UserRoleId

@Entity
class UserRole(
    @EmbeddedId
    val userRoleId: UserRoleId
)
