package habibellah.ayata.elmahir.presentation.feature_teacher

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import habibellah.ayata.elmahir.data.FakeTeacherRepository
import habibellah.ayata.elmahir.data.TeacherDataBuilder.Companion.aTeacher
import habibellah.ayata.elmahir.data.roomDb.entity.Teacher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(JUnit4::class)
class TeacherViewModelTest{

   @get:Rule
   var instantTaskExecutorRule = InstantTaskExecutorRule()
   private val dispatcher = StandardTestDispatcher()
   private lateinit var teacherViewModel : TeacherViewModel

   @Before
   fun setUp() {
      teacherViewModel = TeacherViewModel(FakeTeacherRepository())
      Dispatchers.setMain(dispatcher)
   }


   @Test
   fun testAddTeacher(){
      val observer : Observer<List<Teacher>> = Observer {
         assertEquals(1 , it.size)
      }
      teacherViewModel.addTeacher(aTeacher().withId(1).build())
      dispatcher.scheduler.advanceUntilIdle()
      teacherViewModel.getTeachers().observeForever(observer)
     teacherViewModel.getTeachers().removeObserver(observer)
   }

   @Test
   fun testGetTeachers(){
      val observer : Observer<List<Teacher>> = Observer {
         assertEquals(4 , it.size)
      }
      teacherViewModel.addTeacher(aTeacher().withId(1).build())
      teacherViewModel.addTeacher(aTeacher().withId(2).build())
      teacherViewModel.addTeacher(aTeacher().withId(3).build())
      teacherViewModel.addTeacher(aTeacher().withId(4).build())
      dispatcher.scheduler.advanceUntilIdle()
      teacherViewModel.getTeachers().observeForever(observer)
      teacherViewModel.getTeachers().removeObserver(observer)
   }
}