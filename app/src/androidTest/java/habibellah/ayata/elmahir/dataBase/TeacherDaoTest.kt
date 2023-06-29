package habibellah.ayata.elmahir.dataBase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import habibellah.ayata.elmahir.data.TeacherDataBuilder.Companion.aTeacher
import habibellah.ayata.elmahir.data.roomDb.ElmahirDataBase
import habibellah.ayata.elmahir.data.roomDb.TeacherDao
import habibellah.ayata.elmahir.data.roomDb.entity.Teacher
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TeacherDaoTest {
   @get:Rule
   var instantTaskExecutorRule = InstantTaskExecutorRule()
   private lateinit var elmahirDataBase : ElmahirDataBase
   private lateinit var teacherDao : TeacherDao

   @Before
   fun initDb() {
      elmahirDataBase = Room.inMemoryDatabaseBuilder(
         ApplicationProvider.getApplicationContext() ,
         ElmahirDataBase::class.java
      ).build()
      teacherDao = elmahirDataBase.teacherDao()
   }

   @After
   fun closeDb() {
      elmahirDataBase.close()
   }

   @Test
   fun testAddTeacher() = runBlocking {
      val observer : Observer<List<Teacher>> = Observer {
         Assert.assertEquals(1 , it.size)
      }
      teacherDao.addTeacher(aTeacher().build())
      teacherDao.getTeacherList().observeForever(observer)
      teacherDao.getTeacherList().removeObserver(observer)
   }

   @Test
   fun testGetTeachers() = runBlocking {
      val observer : Observer<List<Teacher>> = Observer {
         Assert.assertEquals(2 , it.size)
      }
      teacherDao.addTeacher(aTeacher().withId(1).build())
      teacherDao.addTeacher(aTeacher().withId(2).build())
      teacherDao.getTeacherList().observeForever(observer)
      teacherDao.getTeacherList().removeObserver(observer)
   }
}