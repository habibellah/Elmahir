package habibellah.ayata.elmahir.dataBase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import habibellah.ayata.elmahir.data.StudentDataBuilder.Companion.aStudent
import habibellah.ayata.elmahir.data.roomDb.ElmahirDataBase
import habibellah.ayata.elmahir.data.roomDb.StudentDao
import habibellah.ayata.elmahir.data.roomDb.entity.Student
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@HiltAndroidTest
class StudentDaoTest {

   @get:Rule
   val hiltRule = HiltAndroidRule(this)

   @get:Rule
   var instantTaskExecutorRule = InstantTaskExecutorRule()

   @Inject
   lateinit var elmahirDataBase : ElmahirDataBase
   private lateinit var studentDao : StudentDao

   @Before
   fun initDb() {
      hiltRule.inject()
      studentDao = elmahirDataBase.studentDao()
   }

   @After
   fun closeDb() {
      elmahirDataBase.close()
   }

   @Test
   fun testAddStudent() = runBlocking{
      val observer: Observer<List<Student>> = Observer {
         Assert.assertEquals(2,it.size)
      }
      studentDao.addStudent(aStudent().withId(1).withGroupName("Old people").build())
      studentDao.addStudent(aStudent().withId(2).withGroupName("Old people").build())
      studentDao.getStudentsBy("Old people").observeForever(observer)
      studentDao.getStudentsBy("Old people").removeObserver(observer)
   }

   @Test
   fun testGetStudentsByGroupId() = runBlocking{
      val observer: Observer<List<Student>> = Observer {
         Assert.assertEquals(2,it.size)
      }
      studentDao.addStudent(aStudent().withId(1).withGroupName("Old people").build())
      studentDao.addStudent(aStudent().withId(2).withGroupName("Old people").build())
      studentDao.addStudent(aStudent().withId(3).withGroupName("Young people").build())
      studentDao.getStudentsBy("Old people").observeForever(observer)
      studentDao.getStudentsBy("Old people").removeObserver(observer)
   }

   @Test
   fun testGetStudentById() = runBlocking{
      studentDao.addStudent(aStudent().withId(1).withStudentName("habibellah").build())
      studentDao.addStudent(aStudent().withId(2).withStudentName("younes").build())
      studentDao.addStudent(aStudent().withId(3).withStudentName("faidi").build())
      val result = studentDao.getStudentBy(1)
      Assert.assertEquals("habibellah",result.studentName)
   }

   @Test
   fun testDeleteStudentById() = runBlocking {
      studentDao.addStudent(aStudent().withId(1).withStudentName("habibellah").build())
      studentDao.addStudent(aStudent().withId(2).withStudentName("younes").build())
      studentDao.addStudent(aStudent().withId(3).withStudentName("faidi").build())
        studentDao.deleteStudentBy(1)
      val result = studentDao.getStudentBy(1)
      Assert.assertEquals(null,result)
   }

   @Test
   fun testUpdateStudentById() = runBlocking {
      studentDao.addStudent(aStudent().withId(1).withStudentName("habibellah").build())
      studentDao.addStudent(aStudent().withId(2).withStudentName("younes").build())
      studentDao.addStudent(aStudent().withId(3).withStudentName("faidi").build())
      studentDao.updateStudent(aStudent().withId(1).withStudentName("faidi").build())
      val result = studentDao.getStudentBy(1)
      Assert.assertEquals("faidi",result.studentName)
   }
}