package ruby.ruby20244thquarteraddressableapi.dummy

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import org.springframework.web.multipart.MultipartFile
import ruby.ruby20244thquarteraddressableapi.common.code.FilePath
import ruby.ruby20244thquarteraddressableapi.common.code.RoleCode
import ruby.ruby20244thquarteraddressableapi.domain.userInfo.repository.UserInfoRepository
import ruby.ruby20244thquarteraddressableapi.domain.vendor.dto.request.VendorPost
import ruby.ruby20244thquarteraddressableapi.domain.vendor.repository.VendorRepository
import ruby.ruby20244thquarteraddressableapi.domain.vendor.service.VendorService
import java.io.File
import java.nio.file.Files
import java.nio.file.Path
import kotlin.io.path.isDirectory
import kotlin.io.path.isRegularFile

@Component
class DummyInitRunner (
    private val vendorRepository: VendorRepository,
    private val userInfoRepository: UserInfoRepository,
    private val vendorService: VendorService,
    @Value("\${file.upload-dir}") private val uploadDir: String
) : CommandLineRunner {
    override fun run(vararg args: String) {
        val vendorSupportingDocumentPath = "$uploadDir/${FilePath.VENDOR_SUPPORTING_DOCUMENT.path}"
        Files.walk(Path.of(vendorSupportingDocumentPath))
            .sorted(Comparator.reverseOrder())
            .forEach {
                if (it.isRegularFile()) {
                    Files.delete(it)
                } else if (it.isDirectory()) {
                    Files.delete(it)
                }
            }

        val filePath = "$uploadDir/test/testPdf.pdf"  // Example file path
        val file = File(filePath)
        val supportingDocument: MultipartFile = FileToMultipartFile(file)

        val roleCodeList = RoleCode.values()
        (1..34).forEach {
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
            vendorService.post(vendorPost, supportingDocument)
        }

        vendorRepository.findAll()
            .filter { (it.id!! % 7).toInt() == 0 }
            .forEach {
                it.deleted = true
                vendorRepository.save(it)
            }
    }
}
