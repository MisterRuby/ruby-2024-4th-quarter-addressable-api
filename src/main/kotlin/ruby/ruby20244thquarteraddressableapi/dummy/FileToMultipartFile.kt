package ruby.ruby20244thquarteraddressableapi.dummy

import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.FileInputStream
import java.io.IOException

class FileToMultipartFile(
    private val file: File
) : MultipartFile {

    override fun getName(): String = file.name

    override fun getOriginalFilename(): String = file.name

    override fun getContentType(): String? = null // You can implement logic to infer the content type

    override fun isEmpty(): Boolean = file.length() == 0L

    override fun getSize(): Long = file.length()

    override fun getBytes(): ByteArray {
        return file.readBytes()
    }

    override fun getInputStream(): FileInputStream {
        return FileInputStream(file)
    }

    @Throws(IOException::class)
    override fun transferTo(dest: File) {
        file.copyTo(dest, overwrite = true)
    }
}
