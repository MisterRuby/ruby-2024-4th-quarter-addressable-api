package ruby.ruby20244thquarteraddressableapi.domain.vendor.repository

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import ruby.ruby20244thquarteraddressableapi.domain.vendor.entity.Vendor

interface VendorRepository : JpaRepository<Vendor, Long> {

    @Query("select v from Vendor v " +
            "left join fetch v.representativeUserInfo " +
            "where v.deleted = false " +
            "and (v.name like %:search% or v.email like %:search% or v.companyNumber like %:search%) " +
            "order by v.id desc")
    fun findBySearch(@Param("search") search: String, pageable: Pageable) : Page<Vendor>

    @Query("select v from Vendor v " +
            "left join fetch v.representativeUserInfo " +
            "left join fetch v.roleList " +
            "where v.id = :id " +
            "and v.deleted = false")
    fun findDetailById(@Param("id") id: Long) : Vendor?
}
