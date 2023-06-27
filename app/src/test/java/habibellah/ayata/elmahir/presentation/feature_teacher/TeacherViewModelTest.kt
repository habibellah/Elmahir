package habibellah.ayata.elmahir.presentation.feature_teacher

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import habibellah.ayata.elmahir.data.FakeTeacherRepository
import habibellah.ayata.elmahir.data.TeacherDataBuilder.Companion.aTeacher
import habibellah.ayata.elmahir.data.repository.TeacherRepository
import habibellah.ayata.elmahir.data.repository.TeacherRepositoryImpl
import habibellah.ayata.elmahir.data.roomDb.entity.Teacher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.Assert
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
      teacherViewModel.addTeacher(aTeacher().withId(1).build())
      teacherViewModel.getTeachers()
      dispatcher.scheduler.advanceUntilIdle()
      assertEquals(1, teacherViewModel.teachers.value?.size ?: 0)
   }

   @Test
   fun testGetTeachers(){
      teacherViewModel.addTeacher(aTeacher().withId(1).build())
      teacherViewModel.addTeacher(aTeacher().withId(2).build())
      teacherViewModel.addTeacher(aTeacher().withId(3).build())
      teacherViewModel.addTeacher(aTeacher().withId(4).build())
      teacherViewModel.getTeachers()
      dispatcher.scheduler.advanceUntilIdle()
      assertEquals(4,teacherViewModel.teachers.value?.size ?: 0)
   }
}