package ruby.ruby20244thquarteraddressableapi.domain.vendor

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import ruby.ruby20244thquarteraddressableapi.domain.vendor.dto.request.VendorPatch
import ruby.ruby20244thquarteraddressableapi.domain.vendor.dto.request.VendorPost
import ruby.ruby20244thquarteraddressableapi.domain.vendor.dto.request.VendorSearch
import ruby.ruby20244thquarteraddressableapi.domain.vendor.dto.response.VendorDetailResponse
import ruby.ruby20244thquarteraddressableapi.domain.vendor.dto.response.VendorResponse
import ruby.ruby20244thquarteraddressableapi.domain.vendor.service.VendorService

/**
 * TODO
 * - 요청값 Validation 처리
 * - 공통 예외 처리
 * - 요청시 권한 검증
 */
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
     * - 첨부파일 확장자 검증(AOP)
     * - 대표 정보 저장시 password 암호화 처리
     */
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    fun post(
        @RequestPart("vendor") vendorPost: VendorPost,
        @RequestParam("supportingDocument") supportingDocument: MultipartFile
    ) {
        vendorService.post(vendorPost, supportingDocument)
    }

    @PatchMapping("/{id}")
    fun patch(@PathVariable("id") id: Long, @RequestBody vendorPatch: VendorPatch) {
        vendorService.patch(id, vendorPatch)
    }
}
