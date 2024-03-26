package neiz.fz.compose.domain.repository

import kotlinx.coroutines.flow.Flow
import neiz.fz.compose.core.Result
import neiz.fz.compose.domain.model.Dish

interface DishRepository {

    suspend fun getDishes() : Flow<Result<List<Dish>>>

}