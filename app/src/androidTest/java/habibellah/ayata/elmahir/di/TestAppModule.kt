package habibellah.ayata.elmahir.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import habibellah.ayata.elmahir.data.roomDb.ElmahirDataBase
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object TestAppModule {

   @Provides
   @Named("test_db")
   fun provideInMemoryElmahirDb(@ApplicationContext context : Context) =
       Room.inMemoryDatabaseBuilder(context,ElmahirDataBase::class.java)
          .allowMainThreadQueries()
          .build()
}