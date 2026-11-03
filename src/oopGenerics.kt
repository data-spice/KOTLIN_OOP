/*
=========================
GENERICS IN KOTLIN
=========================
Generics allow you to write classes, interfaces and functions that can work with
different data types without having to rewrite the same code for every type.

Think of generics as a reusable blueprint that accepts a datatype as a parameter.
 */


data class ApiResponse<T>(
    val success: Boolean,
    val message: String,
    val data: T?
) {
    fun display() {
        println(
            """
            =====================
            RESPONSE DETAILS
            =====================
            Success status:${if (success) "Successfull" else "Failed"}
            Message: $message
            Data: ${data}
        """.trimIndent()
        )
    }
}
data class User2(
    val name: String,
    val email: String
)

data class NetworkDevice(
    val ipAddress: String,
    val hostName: String
)


fun main(){
    val userResponse=ApiResponse<User2>(
        true,
        "User retrieved",
        User2("Victor","vic@xyz.com")
    )
    val deviceResponse = ApiResponse<NetworkDevice>(
        true,
        "Device retrieved",
        NetworkDevice("192.168.1.10", "Server")
    )

    userResponse.display()
    deviceResponse.display()
}