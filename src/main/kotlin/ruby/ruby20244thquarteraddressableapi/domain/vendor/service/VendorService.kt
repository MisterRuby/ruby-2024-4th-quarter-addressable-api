package ruby.ruby20244thquarteraddressableapi.domain.vendor.service

import org.springframework.web.multipart.MultipartFile
import ruby.ruby20244thquarteraddressableapi.domain.vendor.dto.request.VendorPatch
import ruby.ruby20244thquarteraddressableapi.domain.vendor.dto.request.VendorPost
import ruby.ruby20244thquarteraddressableapi.domain.vendor.dto.request.VendorSearch
import ruby.ruby20244thquarteraddressableapi.domain.vendor.dto.response.VendorDetailResponse
import ruby.ruby20244thquarteraddressableapi.domain.vendor.dto.response.VendorResponse

interface VendorService {
    fun getList(vendorSearch: VendorSearch) : List<VendorResponse>
    fun get(id: Long) : VendorDetailResponse
    fun post(vendorPost: VendorPost, supportingDocument: MultipartFile)
    fun patch(id: Long, vendorPatch: VendorPatch)
}
