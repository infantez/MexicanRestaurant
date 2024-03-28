package neiz.fz.compose.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import neiz.fz.compose.data.database.model.DishEntity

@Dao
interface DishDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(dishEntity:DishEntity)

    @Query("select *from dish_table order by id desc")
    fun getAll():List<DishEntity>

    @Query("select *from dish_table where id=:id order by id desc")
    fun getDishesById(id:Int):List<DishEntity>

    @Update
    suspend fun update(dishEntity:DishEntity)

    @Delete
    suspend fun delete(dishEntity:DishEntity)

}