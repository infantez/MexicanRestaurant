package neiz.fz.compose.data.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(

    val success:Boolean,
    @SerializedName("message") // mapea
    val message:String, // usa
    val data:UserDTO

)

data class UserDTO(
    val id:Int,
    val email:String,
    val token:String
)