package ruby.ruby20244thquarteraddressableapi.common.entity

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
class BaseColumn (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @CreatedDate
    @Column(nullable = false, updatable = false)
    var createAt: LocalDateTime? = null,
    @LastModifiedDate
    @Column(nullable = false)
    var updateAt: LocalDateTime? = null,
)
