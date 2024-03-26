package neiz.fz.compose.view.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import neiz.fz.compose.core.Result
import neiz.fz.compose.data.repository.LoginRepositoryImp
import neiz.fz.compose.domain.repository.DishRepository
import neiz.fz.compose.domain.repository.LoginRepository
import javax.inject.Inject
@HiltViewModel
class LoginViewModel @Inject constructor(val repository: LoginRepository): ViewModel() {

    //State
    var state by mutableStateOf(LoginState())

    fun signIn(email:String, password:String){

        // val repository : LoginRepository = LoginRepositoryImp()

        viewModelScope.launch {
            repository.signIn(email, password).onEach {
                when(it){
                    is Result.Error -> {
                        state = state.copy(error = it.message, isLoading = false, success = null)
                    }
                    is Result.Loading -> {
                        state = state.copy(isLoading = true) // Se puede limpiar success y error desde aqui -> fun reset()
                    }
                    is Result.Success -> {
                        state = state.copy(success = it.data, isLoading = false, error = null)
                    }
                }
            }.launchIn(viewModelScope)
        }

    }

    fun reset() {
        state = state.copy(success = null, error = null)
    }
}