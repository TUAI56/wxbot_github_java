package io.github.wechaty.filebox

import com.fasterxml.jackson.annotation.JsonValue


enum class FileBoxType(val code: Int) {

    Unknown(0),

    Base64(1),
    Url(2),
    QRcode(3),

    Buffer(4),
    File(5),
    Stream(6);

    @JsonValue
    fun code(): Int {
        return code
    }

}


data class FileBoxOptionsFile(val type: FileBoxType = FileBoxType.File, var path: String, var name: String) : FileBoxOptions() {
    override fun toString(): String {
        return "FileBoxOptionsFile(type=$type, path='$path')"
    }
}

data class FileBoxOptionsUrl(val type: FileBoxType = FileBoxType.Url, var url: String, var name: String?) : FileBoxOptions() {
    var headers: OutgoingHttpHeaders? = mutableMapOf()
    override fun toString(): String {
        return "FileBoxOptionsUrl(type=$type, path='$url', headrs=$headers)"
    }
}

data class FileBoxOptionsBuffer(var type: FileBoxType = FileBoxType.Buffer, var buffer: ByteArray, var name: String) : FileBoxOptions() {
    override fun toString(): String {
        return "FileBoxOptionsBuffer(type=$type, buffer=$buffer)"
    }

}

data class FileBoxOptionsBase64(var type: FileBoxType = FileBoxType.Base64, var base64: String, var name: String) : FileBoxOptions() {


}

data class FileBoxOptionsStream(val name: String, val type: FileBoxType = FileBoxType.Stream, val stream: Readable) : FileBoxOptions()


data class FileBoxOptionsQRCode(val type: FileBoxType = FileBoxType.QRcode, val qrCode: String, var name: String) : FileBoxOptions() {

}

data class FileBoxOptionsJsonObjectCommon(
        var name: String,
        var metadata: Metadata,
        var type: Int
)

data class FileBoxOptionsJsonObjectBase64(
        val type: FileBoxType = FileBoxType.Base64,
        val base64: String,
        val name: String,
        val metadata: Metadata
) : FileBoxJsonObject()


data class FileBoxJsonObjectUrl(
        val type: FileBoxType = FileBoxType.Url,
        val remoteUrl: String,
        var name: String,
        val metadata: Metadata
) : FileBoxJsonObject() {
    var headers: OutgoingHttpHeaders? = mutableMapOf()
}

data class FileBoxJsonObjectQRCode(
        val type: FileBoxType = FileBoxType.QRcode,
        val qrCode: String,
        var name: String,
        val metadata: Metadata
) : FileBoxJsonObject()

sealed class FileBoxJsonObject

sealed class FileBoxOptions

typealias Metadata = Map<String, Any>

typealias OutgoingHttpHeaders = Map<String, List<String>>


