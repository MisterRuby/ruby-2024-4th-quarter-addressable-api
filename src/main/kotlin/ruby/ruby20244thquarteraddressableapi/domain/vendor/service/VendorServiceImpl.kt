package ruby.ruby20244thquarteraddressableapi.domain.vendor.service

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import ruby.ruby20244thquarteraddressableapi.domain.vendor.dto.request.VendorPatch
import ruby.ruby20244thquarteraddressableapi.domain.vendor.dto.request.VendorPost
import ruby.ruby20244thquarteraddressableapi.domain.vendor.dto.request.VendorSearch
import ruby.ruby20244thquarteraddressableapi.domain.vendor.entity.Vendor
import ruby.ruby20244thquarteraddressableapi.domain.vendor.repository.VendorRepository
import ruby.ruby20244thquarteraddressableapi.domain.vendor.repository.VendorRoleRepository

@Service
class VendorServiceImpl(
    private val vendorRepository: VendorRepository,
    private val vendorRoleRepository: VendorRoleRepository
) : VendorService {

    override fun getList(vendorSearch: VendorSearch) : List<Vendor> {
        // TODO - 별도의 DTO 로 반환해야함
        return vendorRepository.findAll()
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
