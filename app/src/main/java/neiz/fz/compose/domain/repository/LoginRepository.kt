package neiz.fz.compose.domain.repository

import kotlinx.coroutines.flow.Flow
import neiz.fz.compose.core.Result
import neiz.fz.compose.domain.model.User

interface LoginRepository {
    suspend fun signIn(email:String, password:String) : Flow<Result<User>>
}