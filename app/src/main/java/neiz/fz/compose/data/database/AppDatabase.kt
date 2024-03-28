package neiz.fz.compose.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import neiz.fz.compose.data.database.dao.DishDao
import neiz.fz.compose.data.database.model.DishEntity

@Database(entities = [DishEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    //Daos
    abstract fun dishDao() : DishDao

}