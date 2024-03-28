package neiz.fz.compose.data.networking.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("success")
    val success:Boolean,
    @SerializedName("message")
    val message:String,
    @SerializedName("data")
    val data: UserDTO
)

data class UserDTO(
    @SerializedName("id")
    val id:Int,
    @SerializedName("email")
    val email:String,
    @SerializedName("token")
    val token:String
)
data class DishResponse(
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("message")
    val message:String,
    @SerializedName("data")
    val data:List<DishDTO>
)
data class DishDTO(
    @SerializedName("id")
    val id:Int,
    @SerializedName("name")
    val name:String,
    @SerializedName("description")
    val description:String,
    @SerializedName("thumbails")
    val thumbails:String,
    @SerializedName("image")
    val image:String,
    @SerializedName("carbohydrates")
    val carbohydrates:Double,
    @SerializedName("proteins")
    val proteins:Double,
    @SerializedName("rating")
    val rating:Double,
    @SerializedName("price")
    val price:Double,
    @SerializedName("ingredients")
    val ingredients:String,
    @SerializedName("flagHeader")
    val flagHeader:Boolean
)