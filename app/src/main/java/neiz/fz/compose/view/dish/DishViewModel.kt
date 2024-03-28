package neiz.fz.compose.view.dish

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import neiz.fz.compose.core.Result
import neiz.fz.compose.domain.model.Dish
import neiz.fz.compose.domain.repository.DishRepository
import javax.inject.Inject
@HiltViewModel
class DishViewModel @Inject constructor(val dishRepository: DishRepository): ViewModel(){

    var state by mutableStateOf(DishState())
        private set

    fun getDishes(){

        // val dishRepository : DishRepository = DishRepositoryImp()

        viewModelScope.launch {
            dishRepository.getDishes().onEach {
                when(it){
                    is Result.Error -> {
                        state = state.copy(isLoading = false, error = it.message)
                    }
                    is Result.Loading -> {
                        state = state.copy(isLoading = true)
                    }
                    is Result.Success -> {
                        state = state.copy(isLoading = false, success = it.data)
                    }

                }
            }.launchIn(viewModelScope)
        }


    }

    fun saveFavorite(dish: Dish) {

        viewModelScope.launch {
            state = state.copy(isLoading = true)
            withContext(Dispatchers.IO){
                dishRepository.saveDish(dish)
            }
            state = state.copy(isLoading = false)

        }

    }
}
