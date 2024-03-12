package neiz.fz.compose.view.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {

    //State
    var state by mutableStateOf(LoginState())

    fun signIn(email:String, password:String){

    }

}