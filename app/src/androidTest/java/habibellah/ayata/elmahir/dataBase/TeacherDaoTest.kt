package habibellah.ayata.elmahir.dataBase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import habibellah.ayata.elmahir.HiltTestRunner
import habibellah.ayata.elmahir.data.TeacherDataBuilder.Companion.aTeacher
import habibellah.ayata.elmahir.data.roomDb.ElmahirDataBase
import habibellah.ayata.elmahir.data.roomDb.TeacherDao
import habibellah.ayata.elmahir.data.roomDb.entity.Teacher
import habibellah.ayata.elmahir.launchFragmentInHiltContainer
import habibellah.ayata.elmahir.presentation.feature_teacher.TeacherFragment
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject
import javax.inject.Named

@HiltAndroidTest
class TeacherDaoTest {

   @get:Rule
   val hiltRule = HiltAndroidRule(this)

   @get:Rule
   var instantTaskExecutorRule = InstantTaskExecutorRule()

   @Inject
   @Named("test_db")
    lateinit var elmahirDataBase : ElmahirDataBase
   private lateinit var teacherDao : TeacherDao

   @Before
   fun initDb() {
      hiltRule.inject()
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