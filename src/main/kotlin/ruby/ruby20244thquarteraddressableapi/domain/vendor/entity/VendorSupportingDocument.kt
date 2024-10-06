package ruby.ruby20244thquarteraddressableapi.domain.vendor.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import ruby.ruby20244thquarteraddressableapi.common.code.FileExtension
import ruby.ruby20244thquarteraddressableapi.common.entity.BaseColumn

@Entity
class VendorSupportingDocument(
    @Column(nullable = false)
    val originalFilename: String,
    @Column(nullable = false)
    val filename: String,
    @Column(nullable = false)
    val filePath: String,
    @Column(nullable = false)
    val fileSize: Long,
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    val fileExtension: FileExtension,
) : BaseColumn()
