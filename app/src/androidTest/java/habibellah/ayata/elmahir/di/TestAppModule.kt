package habibellah.ayata.elmahir.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import habibellah.ayata.elmahir.data.repository.GroupRepository
import habibellah.ayata.elmahir.data.repository.GroupRepositoryImpl
import habibellah.ayata.elmahir.data.repository.StudentRepository
import habibellah.ayata.elmahir.data.repository.StudentRepositoryImpl
import habibellah.ayata.elmahir.data.repository.TeacherRepository
import habibellah.ayata.elmahir.data.repository.TeacherRepositoryImpl
import habibellah.ayata.elmahir.data.roomDb.AbsentDao
import habibellah.ayata.elmahir.data.roomDb.ElmahirDataBase
import habibellah.ayata.elmahir.data.roomDb.GroupsDao
import habibellah.ayata.elmahir.data.roomDb.StudentDao
import habibellah.ayata.elmahir.data.roomDb.TeacherDao
import javax.inject.Named
import javax.inject.Singleton

@Module
@TestInstallIn(components = [SingletonComponent::class], replaces = [ElmahirModule::class])
object TestAppModule {


   @Provides
   fun provideDatabase(@ApplicationContext context: Context) : ElmahirDataBase {
      return Room.inMemoryDatabaseBuilder(context, ElmahirDataBase::class.java).allowMainThreadQueries().build()
   }

   @Provides
   fun provideStudentDao(db: ElmahirDataBase) = db.studentDao()

   @Provides
   fun provideTeacherDao(db: ElmahirDataBase) = db.teacherDao()

   @Provides
   fun provideGroupsDao(db: ElmahirDataBase) = db.groupsDao()

   @Provides
   fun provideAbsentDao(db: ElmahirDataBase) = db.absentDao()

   @Provides
   fun provideTeacherRepository(teacherDao : TeacherDao): TeacherRepository {
      return TeacherRepositoryImpl(teacherDao)
   }

   @Provides
   fun provideGroupRepository(groupsDao : GroupsDao) : GroupRepository {
      return GroupRepositoryImpl(groupsDao)
   }

   @Provides
   fun provideStudentRepository(studentDao : StudentDao , absentDao : AbsentDao): StudentRepository {
      return StudentRepositoryImpl(studentDao = studentDao,absentDao = absentDao)
   }
}