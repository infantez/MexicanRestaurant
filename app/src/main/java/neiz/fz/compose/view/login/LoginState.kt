package neiz.fz.compose.view.login

data class LoginState(
    val isLoading:Boolean = false,
    val error:String?=null,
    val success:String?=null
)
