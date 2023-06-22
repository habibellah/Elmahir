package habibellah.ayata.elmahir.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import habibellah.ayata.elmahir.data.roomDb.ElmahirDataBase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ElmahirModule {

   private const val DB_NAME = "quran_school"
   @Singleton
   @Provides
   fun provideQuestionsDatabase(
      @ApplicationContext app: Context
   ) = Room.databaseBuilder(
      app,
      ElmahirDataBase::class.java,
      DB_NAME
   ).build()

   @Singleton
   @Provides
   fun provideStudentDao(db: ElmahirDataBase) = db.studentDao()

   @Singleton
   @Provides
   fun provideTeacherDao(db: ElmahirDataBase) = db.teacherDao()
}