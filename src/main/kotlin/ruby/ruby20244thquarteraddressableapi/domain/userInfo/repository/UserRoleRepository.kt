package ruby.ruby20244thquarteraddressableapi.domain.userInfo.repository

import org.springframework.data.jpa.repository.JpaRepository
import ruby.ruby20244thquarteraddressableapi.domain.userInfo.entity.UserRole
import ruby.ruby20244thquarteraddressableapi.domain.userInfo.entity.embedded.UserRoleId

interface UserRoleRepository : JpaRepository<UserRole, UserRoleId>
