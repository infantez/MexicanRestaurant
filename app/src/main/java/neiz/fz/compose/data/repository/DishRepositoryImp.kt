package neiz.fz.compose.data.repository

import android.content.SharedPreferences
import androidx.compose.ui.res.stringResource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import neiz.fz.compose.R
import neiz.fz.compose.core.Result
import neiz.fz.compose.data.networking.Api
import neiz.fz.compose.domain.model.Dish
import neiz.fz.compose.domain.model.toDishList
import neiz.fz.compose.domain.repository.DishRepository
import java.io.IOException
import javax.inject.Inject

class DishRepositoryImp @Inject constructor(val sharedPreferences: SharedPreferences): DishRepository {
    override suspend fun getDishes(): Flow<Result<List<Dish>>> = flow {

        try {
            emit(Result.Loading())
            val token = sharedPreferences.getString("KEY_TOKEN", "")
            val response = Api.build().getDishes("Bearer $token")

            if(response.isSuccessful){

                val dishes = response.body()?.data?.toDishList()

                emit(Result.Success(data = dishes))

            } else {
                emit(Result.Error(message = response.message()))
            }


        } catch (ex:Exception){
            emit(Result.Error(message = "Compruebe su conexión a Internet"))
        } catch (ex: IOException){
            emit(Result.Error(message = ex.message))
        }
    }

}