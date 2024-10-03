package ruby.ruby20244thquarteraddressableapi.dummy

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import ruby.ruby20244thquarteraddressableapi.common.code.RoleCode
import ruby.ruby20244thquarteraddressableapi.domain.userInfo.repository.UserInfoRepository
import ruby.ruby20244thquarteraddressableapi.domain.vendor.dto.request.VendorPost
import ruby.ruby20244thquarteraddressableapi.domain.vendor.repository.VendorRepository
import ruby.ruby20244thquarteraddressableapi.domain.vendor.service.VendorService

@Component
class DummyInitRunner (
    private val vendorRepository: VendorRepository,
    private val userInfoRepository: UserInfoRepository,
    private val vendorService: VendorService
) : CommandLineRunner {
    override fun run(vararg args: String) {
        val roleCodeList = RoleCode.values()
        (1..1000).forEach {
            val key = it.toString()
            val vendorPost = VendorPost(
                companyNumber = "12345600000".substring(0, 10 - key.length) + key,
                name = "test$key",
                contactNumber = "010-0000-0000".substring(0, 13 - key.length) + key,
                email = "test$key@email.com",
                roleList = listOf(roleCodeList[it % 4].name),
                representativeUserInfo = VendorPost.RepresentativeUserInfo(
                    userId = "user$key",
                    password = "1234567890",
                    name = "사용자$key",
                    phoneNumber = "010-0000-0000".substring(0, 13 - key.length) + key,
                    email = "user$key@email.com",
                )
            )
            vendorService.post(vendorPost)
        }

        vendorRepository.findAll()
            .filter { (it.id!! % 7).toInt() == 0 }
            .forEach {
                it.deleted = true
                vendorRepository.save(it)
            }
    }
}
