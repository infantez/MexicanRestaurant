package neiz.fz.compose.domain.model

import neiz.fz.compose.data.model.UserDTO

data class User (
    val id : Int,
    val email : String
)

fun UserDTO.toUser() : User {
    return User (
        id = this.id,
        email = this.email
    )
}