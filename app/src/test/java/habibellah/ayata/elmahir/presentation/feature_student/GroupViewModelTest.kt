package habibellah.ayata.elmahir.presentation.feature_student

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import habibellah.ayata.elmahir.data.FakeGroupRepository
import habibellah.ayata.elmahir.data.GroupDataBuilder
import habibellah.ayata.elmahir.data.roomDb.entity.Group
import habibellah.ayata.elmahir.presentation.feature_student.groups.GroupViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
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
class GroupViewModelTest {

   @get:Rule
   var instantTaskExecutorRule = InstantTaskExecutorRule()
   private val dispatcher = StandardTestDispatcher()

   private lateinit var groupViewModel : GroupViewModel

   @Before
   fun setUp() {
      groupViewModel = GroupViewModel(FakeGroupRepository())
      Dispatchers.setMain(dispatcher)
   }

   @Test
   fun testAddGroup(){
      val observer : Observer<List<Group>> = Observer {
         Assert.assertEquals(1 , it.size)
      }
      groupViewModel.addGroup(GroupDataBuilder.aGroup().withId(1).build())
      dispatcher.scheduler.advanceUntilIdle()
      groupViewModel.getGroups().observeForever(observer)
      groupViewModel.getGroups().removeObserver(observer)
   }

   @Test
   fun testGetGroups(){
      val observer : Observer<List<Group>> = Observer {
         Assert.assertEquals(4 , it.size)
      }
      groupViewModel.addGroup(GroupDataBuilder.aGroup().withId(1).build())
      groupViewModel.addGroup(GroupDataBuilder.aGroup().withId(2).build())
      groupViewModel.addGroup(GroupDataBuilder.aGroup().withId(3).build())
      groupViewModel.addGroup(GroupDataBuilder.aGroup().withId(4).build())
      dispatcher.scheduler.advanceUntilIdle()
      groupViewModel.getGroups().observeForever(observer)
      groupViewModel.getGroups().removeObserver(observer)
   }
}