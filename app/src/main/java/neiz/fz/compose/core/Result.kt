package neiz.fz.compose.core

import neiz.fz.compose.data.networking.model.UserDTO

sealed class Result<T>(val data:T?=null,val message:String?=null) {

    class Success<T>(data: T?) : Result<T>(data = data)
    class Error<T>(message: String?) : Result<T>(message = message)
    class Loading<T> : Result<T>()
}
