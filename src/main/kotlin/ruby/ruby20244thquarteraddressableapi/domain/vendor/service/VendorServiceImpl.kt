package ruby.ruby20244thquarteraddressableapi.domain.vendor.service

import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.support.PageableUtils
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import ruby.ruby20244thquarteraddressableapi.domain.vendor.dto.request.VendorPatch
import ruby.ruby20244thquarteraddressableapi.domain.vendor.dto.request.VendorPost
import ruby.ruby20244thquarteraddressableapi.domain.vendor.dto.request.VendorSearch
import ruby.ruby20244thquarteraddressableapi.domain.vendor.dto.response.VendorResponse
import ruby.ruby20244thquarteraddressableapi.domain.vendor.entity.Vendor
import ruby.ruby20244thquarteraddressableapi.domain.vendor.repository.VendorRepository
import ruby.ruby20244thquarteraddressableapi.domain.vendor.repository.VendorRoleRepository

@Service
class VendorServiceImpl(
    private val vendorRepository: VendorRepository,
    private val vendorRoleRepository: VendorRoleRepository
) : VendorService {

    override fun getList(vendorSearch: VendorSearch) : List<VendorResponse> {
        return vendorSearch.run {
            val pageable = PageRequest.of(page - 1, pageSize)
            vendorRepository.findBySearch(vendorSearch.search, pageable).content.map {
                VendorResponse(
                    id = it.id!!,
                    companyNumber = it.companyNumber,
                    name = it.name,
                    contactNumber = it.contactNumber,
                    email = it.email,
                    useYn = it.useYn,
                    deleted = it.deleted,
                    representativeUsername = it.representativeUserInfo?.name
                )
            }
        }
    }

    override fun get(id: Long): Vendor {
        // TODO - 별도의 DTO 로 반환해야함
        return vendorRepository.findByIdOrNull(id) ?: throw RuntimeException()
    }

    override fun post(vendorPost: VendorPost) {
        TODO("Not yet implemented")
    }

    override fun patch(vendorPatch: VendorPatch) {
        TODO("Not yet implemented")
    }

    override fun delete(id: Long) {
        TODO("Not yet implemented")
    }
}
