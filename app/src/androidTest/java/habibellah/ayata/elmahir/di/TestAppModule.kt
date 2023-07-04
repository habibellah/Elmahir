package habibellah.ayata.elmahir.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import habibellah.ayata.elmahir.data.repository.TeacherRepository
import habibellah.ayata.elmahir.data.repository.TeacherRepositoryImpl
import habibellah.ayata.elmahir.data.roomDb.ElmahirDataBase
import habibellah.ayata.elmahir.data.roomDb.TeacherDao
import javax.inject.Named
import javax.inject.Singleton

@Module
@TestInstallIn(components = [SingletonComponent::class], replaces = [ElmahirModule::class])
object TestAppModule {


   @Singleton
   @Provides
   fun provideDatabase(@ApplicationContext context: Context) : ElmahirDataBase {
      return Room.inMemoryDatabaseBuilder(context, ElmahirDataBase::class.java).allowMainThreadQueries().build()
   }

   @Singleton
   @Provides
   fun provideStudentDao(db: ElmahirDataBase) = db.studentDao()

   @Singleton
   @Provides
   fun provideTeacherDao(db: ElmahirDataBase) = db.teacherDao()

   @Provides
   fun provideTeacherRepository(teacherDao : TeacherDao): TeacherRepository {
      return TeacherRepositoryImpl(teacherDao)
   }
}