package neiz.fz.compose.domain.repository

import dagger.Provides
import kotlinx.coroutines.flow.Flow
import neiz.fz.compose.core.Result
import neiz.fz.compose.domain.model.User
import javax.inject.Singleton


interface LoginRepository {

    suspend fun signIn(email:String, password:String) : Flow<Result<User>>
}