package ruby.ruby20244thquarteraddressableapi.domain.vendor.service

import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ruby.ruby20244thquarteraddressableapi.common.code.RoleCode
import ruby.ruby20244thquarteraddressableapi.domain.userInfo.entity.UserInfo
import ruby.ruby20244thquarteraddressableapi.domain.userInfo.repository.UserInfoRepository
import ruby.ruby20244thquarteraddressableapi.domain.vendor.dto.request.VendorPatch
import ruby.ruby20244thquarteraddressableapi.domain.vendor.dto.request.VendorPost
import ruby.ruby20244thquarteraddressableapi.domain.vendor.dto.request.VendorSearch
import ruby.ruby20244thquarteraddressableapi.domain.vendor.dto.response.VendorDetailResponse
import ruby.ruby20244thquarteraddressableapi.domain.vendor.dto.response.VendorResponse
import ruby.ruby20244thquarteraddressableapi.domain.vendor.entity.Vendor
import ruby.ruby20244thquarteraddressableapi.domain.vendor.entity.VendorRole
import ruby.ruby20244thquarteraddressableapi.domain.vendor.entity.embedded.VendorRoleId
import ruby.ruby20244thquarteraddressableapi.domain.vendor.repository.VendorRepository
import ruby.ruby20244thquarteraddressableapi.domain.vendor.repository.VendorRoleRepository

@Service
class VendorServiceImpl(
    private val vendorRepository: VendorRepository,
    private val vendorRoleRepository: VendorRoleRepository,
    private val userInfoRepository: UserInfoRepository
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

    override fun get(id: Long): VendorDetailResponse {
        return vendorRepository.findDetailById(id)?.run {
            val userList = userInfoRepository.findByVendor(this)
            VendorDetailResponse(
                id = id,
                companyNumber = companyNumber,
                name = name,
                contactNumber = contactNumber,
                email = email,
                useYn = useYn,
                deleted = deleted,
                representativeUsername = representativeUserInfo?.name,
                roleList = roleList.map { it.vendorRoleId.roleCode },
                userList = userList.map {
                    VendorDetailResponse.VendorUserInfo(
                        id = it.id!!,
                        userId = it.userId,
                        name = it.name,
                        phoneNumber = it.phoneNumber,
                        email = it.email,
                        useYn = it.useYn,
                        deleted = it.deleted
                    )
                }
            )
        } ?: throw RuntimeException("업체 정보를 찾을 수 없습니다.")
    }

    @Transactional
    override fun post(vendorPost: VendorPost) {
        vendorPost.apply {
            val vendor = Vendor(
                companyNumber = companyNumber,
                name = name,
                contactNumber = contactNumber,
                email = email,
                useYn = true,
                deleted = false,
            ).let { vendorRepository.save(it) }

            roleList
                .map { VendorRole(VendorRoleId(vendor, RoleCode.valueOf(it))) }
                .let { vendorRoleRepository.saveAll(it) }

            representativeUserInfo
                .run {
                    UserInfo(
                        userId = userId,
                        password = password,
                        name = name,
                        phoneNumber = phoneNumber,
                        email = email,
                        useYn = true,
                        deleted = false,
                        vendor = vendor
                    )
                }.let {
                    userInfoRepository.save(it)
                    vendor.representativeUserInfo = it
                    vendorRepository.save(vendor)
                }
        }
    }

    override fun patch(vendorPatch: VendorPatch) {
        TODO("Not yet implemented")
    }

    override fun delete(id: Long) {
        TODO("Not yet implemented")
    }
}
