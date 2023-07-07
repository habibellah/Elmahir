package habibellah.ayata.elmahir.dataBase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import habibellah.ayata.elmahir.data.StudentDataBuilder.Companion.aStudent
import habibellah.ayata.elmahir.data.roomDb.ElmahirDataBase
import habibellah.ayata.elmahir.data.roomDb.StudentDao
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
   fun testAddStudent(){
      studentDao.addStudent(aStudent().withId(1).build())
      studentDao.addStudent(aStudent().withId(2).build())
      val students = studentDao.getStudents()
      Assert.assertEquals(2,students.size)
   }

   @Test
   fun testGetStudents(){
      studentDao.addStudent(aStudent().withId(1).build())
      studentDao.addStudent(aStudent().withId(2).build())
      studentDao.addStudent(aStudent().withId(3).build())
      val students = studentDao.getStudents()
      Assert.assertEquals(3,students.size)
   }

   @Test
   fun testGetStudentById(){
      studentDao.addStudent(aStudent().withId(1).withStudentName("habibellah").build())
      studentDao.addStudent(aStudent().withId(2).withStudentName("younes").build())
      studentDao.addStudent(aStudent().withId(3).withStudentName("faidi").build())
      val result = studentDao.getStudentBy(1)
      Assert.assertEquals("habibellah",result.studentName)
   }
}