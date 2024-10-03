package ruby.ruby20244thquarteraddressableapi.domain.vendor.service

import ruby.ruby20244thquarteraddressableapi.domain.vendor.dto.request.VendorPatch
import ruby.ruby20244thquarteraddressableapi.domain.vendor.dto.request.VendorPost
import ruby.ruby20244thquarteraddressableapi.domain.vendor.dto.request.VendorSearch
import ruby.ruby20244thquarteraddressableapi.domain.vendor.dto.response.VendorResponse
import ruby.ruby20244thquarteraddressableapi.domain.vendor.entity.Vendor

interface VendorService {
    fun getList(vendorSearch: VendorSearch) : List<VendorResponse>
    fun get(id: Long) : Vendor
    fun post(vendorPost: VendorPost)
    fun patch(vendorPatch: VendorPatch)
    fun delete(id: Long)
}
