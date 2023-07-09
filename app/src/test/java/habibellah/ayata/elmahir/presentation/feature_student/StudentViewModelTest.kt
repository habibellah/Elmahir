package habibellah.ayata.elmahir.presentation.feature_student

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import habibellah.ayata.elmahir.data.FakeGroupRepository
import habibellah.ayata.elmahir.data.FakeStudentRepository
import habibellah.ayata.elmahir.data.StudentDataBuilder.Companion.aStudent
import habibellah.ayata.elmahir.data.repository.StudentRepository
import habibellah.ayata.elmahir.data.roomDb.entity.Student
import habibellah.ayata.elmahir.presentation.feature_student.groups.GroupViewModel
import habibellah.ayata.elmahir.presentation.feature_student.students.StudentViewModel
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

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(JUnit4::class)
class StudentViewModelTest {

   @get:Rule
   var instantTaskExecutorRule = InstantTaskExecutorRule()
   private val dispatcher = StandardTestDispatcher()

   private lateinit var studentViewModel : StudentViewModel

   @Before
   fun setUp() {
      studentViewModel = StudentViewModel(FakeStudentRepository())
      Dispatchers.setMain(dispatcher)
   }

   @Test
   fun testGetStudentsByGroupName() {
      val observer : Observer<List<Student>> = Observer {
         Assert.assertEquals(3,it.size)
      }
      studentViewModel.addStudent(aStudent().withId(1).withGroupName("Old people").build())
      studentViewModel.addStudent(aStudent().withId(2).withGroupName("Old people").build())
      studentViewModel.addStudent(aStudent().withId(3).withGroupName("Old people").build())
      studentViewModel.getStudents("Old people")
      dispatcher.scheduler.advanceUntilIdle()
      studentViewModel.students.observeForever(observer)
      studentViewModel.students.removeObserver(observer)
   }

   @Test
   fun testDeleteStudentById() = runBlocking {
      val observer : Observer<List<Student>> = Observer {
         Assert.assertEquals(2,it.size)
      }
      studentViewModel.addStudent(aStudent().withId(1).withGroupName("Old people").build())
      studentViewModel.addStudent(aStudent().withId(2).withGroupName("Old people").build())
      studentViewModel.addStudent(aStudent().withId(3).withGroupName("Old people").build())
      studentViewModel.deleteStudentBy(1)
      studentViewModel.getStudents("Old people")
      dispatcher.scheduler.advanceUntilIdle()
      studentViewModel.students.observeForever(observer)
      studentViewModel.students.removeObserver(observer)
   }
}