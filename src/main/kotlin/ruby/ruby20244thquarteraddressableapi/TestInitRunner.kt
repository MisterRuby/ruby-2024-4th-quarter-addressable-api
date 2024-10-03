package ruby.ruby20244thquarteraddressableapi

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import ruby.ruby20244thquarteraddressableapi.domain.vendor.entity.Vendor
import ruby.ruby20244thquarteraddressableapi.domain.vendor.repository.VendorRepository

@Component
class TestInitRunner (
    private val vendorRepository: VendorRepository
) : CommandLineRunner {
    override fun run(vararg args: String) {
        val vendorList = (1..1000).map {
            val key = it.toString()
            Vendor(
                contactNumber = "12345600000".substring(0, 10 - key.length) + key,
                name = "test$it",
                companyNumber = "010-0000-0000".substring(0, 13 - key.length) + key,
                email = "test$it@email.com",
                useYn = it % 2 == 0,
                deleted = false
            )
        }
        vendorRepository.saveAll(vendorList)
    }
}
