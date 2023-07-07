package habibellah.ayata.elmahir.presentation.feature_student

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import habibellah.ayata.elmahir.data.AbsentDataBuilder.Companion.anAbsent
import habibellah.ayata.elmahir.data.FakeStudentRepository
import habibellah.ayata.elmahir.data.StudentDataBuilder.Companion.aStudent
import habibellah.ayata.elmahir.data.repository.StudentRepository
import habibellah.ayata.elmahir.data.roomDb.entity.Absent
import habibellah.ayata.elmahir.data.roomDb.entity.Student
import habibellah.ayata.elmahir.presentation.feature_student.students.StudentDetailsViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
@ExperimentalCoroutinesApi
class StudentDetailViewModelTest {

   @get:Rule
   var instantTaskExecutorRule = InstantTaskExecutorRule()
   private val dispatcher = StandardTestDispatcher()

   private lateinit var studentDetailsViewModel : StudentDetailsViewModel
   private lateinit var studentRepository : StudentRepository

   @Before
   fun setUp() {
      studentRepository = FakeStudentRepository()
      studentDetailsViewModel = StudentDetailsViewModel(studentRepository)
      Dispatchers.setMain(dispatcher)
   }


   @Test
   fun addAbsentTest() = runBlocking{
      val observer : Observer<List<Absent>> = Observer {
         Assert.assertEquals(3,it.size)
      }
      studentDetailsViewModel.addAbsent(anAbsent().withId(1).withStudentId(2).build())
      studentDetailsViewModel.addAbsent(anAbsent().withId(1).withStudentId(2).build())
      studentDetailsViewModel.addAbsent(anAbsent().withId(1).withStudentId(2).build())
      dispatcher.scheduler.advanceUntilIdle()
      studentDetailsViewModel.getAbsentsBy(2).observeForever(observer)
      studentDetailsViewModel.getAbsentsBy(2).removeObserver(observer)
   }

   @Test
   fun testGetStudentDetailsById() = runBlocking {
      val observer : Observer<Student> = Observer {
         Assert.assertEquals(3,it.id)
      }
      studentRepository.addStudent(aStudent().withId(1).build())
      studentRepository.addStudent(aStudent().withId(2).build())
      studentRepository.addStudent(aStudent().withId(3).build())
      studentDetailsViewModel.getStudentBy(3)
      dispatcher.scheduler.advanceUntilIdle()
      studentDetailsViewModel.student.observeForever(observer)
      studentDetailsViewModel.student.removeObserver(observer)
   }
}