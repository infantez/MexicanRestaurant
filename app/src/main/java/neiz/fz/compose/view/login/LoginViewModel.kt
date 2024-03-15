package neiz.fz.compose.view.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import neiz.fz.compose.core.Result
import neiz.fz.compose.data.repository.LoginRepositoryImp
import neiz.fz.compose.domain.repository.LoginRepository

class LoginViewModel : ViewModel() {

    //State
    var state by mutableStateOf(LoginState())

    fun signIn(email:String, password:String){

        val repository : LoginRepository = LoginRepositoryImp()

        viewModelScope.launch {
            repository.signIn(email, password).onEach {
                when(it){
                    is Result.Error -> {
                        state = state.copy(error = it.message, isLoading = false)
                    }
                    is Result.Loading -> {
                        state = state.copy(isLoading = true)
                    }
                    is Result.Success -> {
                        state = state.copy(success = it.data, isLoading = false)
                    }
                }
            }.launchIn(viewModelScope)
        }

    }

}