package neiz.fz.compose.data.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(

    @SerializedName("success")
    val success:Boolean,
    @SerializedName("message") // mapea
    val message:String, // usa
    @SerializedName("data")
    val data:UserDTO

)

data class UserDTO(
    @SerializedName("id")
    val id:Int,
    @SerializedName("email")
    val email:String,
    @SerializedName("token")
    val token:String
)