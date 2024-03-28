package neiz.fz.compose.di

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import neiz.fz.compose.data.repository.DishRepositoryImp
import neiz.fz.compose.data.repository.LoginRepositoryImp
import neiz.fz.compose.domain.repository.DishRepository
import neiz.fz.compose.domain.repository.LoginRepository
import javax.inject.Singleton
import androidx.room.Room
import neiz.fz.compose.data.database.AppDatabase
import neiz.fz.compose.data.database.dao.DishDao


@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideSharePreferences(@ApplicationContext context: Context): SharedPreferences {
        val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
        return EncryptedSharedPreferences.create(
            "PREFERENCES_TOKEN",
            masterKeyAlias,
            context,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }

    @Provides
    @Singleton
    fun provideLoginRepository(sharedPreferences: SharedPreferences): LoginRepository {
        return LoginRepositoryImp(sharedPreferences)
    }

    @Provides
    @Singleton
    fun provideDishRepository(
        sharedPreferences: SharedPreferences,
        dishDao: DishDao
    ): DishRepository {
        return DishRepositoryImp(sharedPreferences, dishDao)
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "dbMXN"
        ).build()

    @Provides
    @Singleton
    fun provideDao(db: AppDatabase): DishDao = db.dishDao()

}
