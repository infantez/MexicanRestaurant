package neiz.fz.compose.view.dish

import neiz.fz.compose.domain.model.Dish

data class DishState(

    val isLoading : Boolean = false,
    val error : String ?= null,
    val success : List<Dish> ?= null

)
