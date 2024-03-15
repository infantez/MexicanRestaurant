package neiz.fz.compose.view.login

import neiz.fz.compose.domain.model.User

data class LoginState(
    val isLoading:Boolean = false,
    val error:String?=null,
    val success: User?=null
)
