package neiz.fz.compose.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import neiz.fz.compose.core.Result
import neiz.fz.compose.data.model.LoginRequest
import neiz.fz.compose.data.networking.Api
import neiz.fz.compose.domain.model.User
import neiz.fz.compose.domain.model.toUser
import neiz.fz.compose.domain.repository.LoginRepository
import okio.IOException

class LoginRepositoryImp : LoginRepository{
    override suspend fun signIn(email: String, password: String) : Flow<Result<User>> = flow {
        try {

            emit(Result.Loading())

            val response = Api.build().logIn(
                LoginRequest(
                    email = email,
                    password = password)
            )

            if(response.isSuccessful){
                // Respuesta satistafctoria 200 Ok
                val loginResponse = response.body()
                if(loginResponse?.success == true){
                    // Usuario existe
                    emit(Result.Success(data = loginResponse.data.toUser()))


                } else {
                    // Usuario no existe
                    emit(Result.Error(message = loginResponse?.message))

                }

            } else {
                // Error o advertencia
                emit(Result.Error(message = response.message()))
            }
        } catch (ex:Exception){
            emit(Result.Error(message = "Compruebe su conexión a Internet"))
        } catch (ex:IOException){
            emit(Result.Error(message = ex.message))
        }
    }

}