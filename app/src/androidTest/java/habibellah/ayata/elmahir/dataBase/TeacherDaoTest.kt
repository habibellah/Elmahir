package habibellah.ayata.elmahir.dataBase

import android.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import habibellah.ayata.elmahir.data.TeacherDataBuilder.Companion.aTeacher
import habibellah.ayata.elmahir.data.roomDb.ElmahirDataBase
import habibellah.ayata.elmahir.data.roomDb.TeacherDao
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
         ApplicationProvider.getApplicationContext(),
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
      teacherDao.addTeacher(aTeacher().build())

      val result = teacherDao.getTeacherList()

      Assert.assertEquals(1,result.size)
   }
}