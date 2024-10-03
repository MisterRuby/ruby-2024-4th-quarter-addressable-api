package ruby.ruby20244thquarteraddressableapi.domain.vendor

import org.springframework.web.bind.annotation.*
import ruby.ruby20244thquarteraddressableapi.domain.vendor.dto.request.VendorPatch
import ruby.ruby20244thquarteraddressableapi.domain.vendor.dto.request.VendorPost
import ruby.ruby20244thquarteraddressableapi.domain.vendor.dto.request.VendorSearch
import ruby.ruby20244thquarteraddressableapi.domain.vendor.dto.response.VendorDetailResponse
import ruby.ruby20244thquarteraddressableapi.domain.vendor.dto.response.VendorResponse
import ruby.ruby20244thquarteraddressableapi.domain.vendor.service.VendorService

@RestController
@RequestMapping("/vendors")
class VendorController(
    private val vendorService: VendorService
) {

    @GetMapping
    fun getList(@RequestBody vendorSearch: VendorSearch) : List<VendorResponse> {
        return vendorService.getList(vendorSearch)
    }

    @GetMapping("/{id}")
    fun get(@PathVariable("id") id: Long) : VendorDetailResponse {
        return vendorService.get(id)
    }

    /**
     * TODO
     * - 사업자 정보 등록시 증명하기 위한 사업자등록증 PDF 파일을 첨부하여 요청
     */
    @PostMapping
    fun post(@RequestBody vendorPost: VendorPost) {
        vendorService.post(vendorPost)
    }

    @PatchMapping("/{id}")
    fun patch(@PathVariable("id") id: Long, @RequestBody vendorPatch: VendorPatch) {
        // TODO - id 에 해당하는 업체 정보수정. soft delete 처리도 patch 요청으로 처리
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Long) {
        // TODO - id 에 해당하는 업체 정보 삭제(soft delete)
    }
}
