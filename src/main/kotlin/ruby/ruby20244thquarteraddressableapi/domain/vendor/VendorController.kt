package ruby.ruby20244thquarteraddressableapi.domain.vendor

import org.springframework.web.bind.annotation.*
import ruby.ruby20244thquarteraddressableapi.domain.vendor.dto.request.VendorPatch
import ruby.ruby20244thquarteraddressableapi.domain.vendor.dto.request.VendorPost
import ruby.ruby20244thquarteraddressableapi.domain.vendor.dto.request.VendorSearch
import ruby.ruby20244thquarteraddressableapi.domain.vendor.entity.Vendor
import ruby.ruby20244thquarteraddressableapi.domain.vendor.service.VendorService

@RestController
@RequestMapping("/vendors")
class VendorController(
    private val vendorService: VendorService
) {

    @GetMapping
    fun getList(@RequestBody vendorSearch: VendorSearch) : List<Vendor> {
        return vendorService.getList(vendorSearch)
    }

    @GetMapping("/{id}")
    fun get(@PathVariable("id") id: Long) {
        // TODO - id 에 해당하는 업체 정보 조회
    }

    @PostMapping
    fun post(vendorPost: VendorPost) {
        // TODO - 업체 정보 등록
    }

    @PatchMapping("/{id}")
    fun patch(@PathVariable("id") id: Long, vendorPatch: VendorPatch) {
        // TODO - id 에 해당하는 업체 정보수정
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Long) {
        // TODO - id 에 해당하는 업체 정보 삭제(soft delete)
    }
}
