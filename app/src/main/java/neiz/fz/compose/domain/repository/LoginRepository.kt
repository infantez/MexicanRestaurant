package neiz.fz.compose.domain.repository

interface LoginRepository {
    fun signIn(email:String, password:String) : Unit
}