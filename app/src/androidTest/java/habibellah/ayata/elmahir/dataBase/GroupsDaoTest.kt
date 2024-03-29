package habibellah.ayata.elmahir.dataBase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import habibellah.ayata.elmahir.data.GroupDataBuilder.Companion.aGroup
import habibellah.ayata.elmahir.data.roomDb.ElmahirDataBase
import habibellah.ayata.elmahir.data.roomDb.GroupsDao
import habibellah.ayata.elmahir.data.roomDb.entity.Group
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@HiltAndroidTest
class GroupsDaoTest {

   @get:Rule
   val hiltRule = HiltAndroidRule(this)

   @get:Rule
   var instantTaskExecutorRule = InstantTaskExecutorRule()

   @Inject
   lateinit var elmahirDataBase : ElmahirDataBase
   private lateinit var groupsDao : GroupsDao

   @Before
   fun initDb() {
      hiltRule.inject()
      groupsDao = elmahirDataBase.groupsDao()
   }

   @After
   fun closeDb() {
      elmahirDataBase.close()
   }

   @Test
   fun testAddNewGroup() = runBlocking{
      val observer : Observer<List<Group>> = Observer {
         Assert.assertEquals(1, it.size)
      }
      groupsDao.addGroup(aGroup().withId(1).build())
      groupsDao.getGroups().observeForever(observer)
      groupsDao.getGroups().removeObserver(observer)
   }

   @Test
   fun testGetGroups() = runBlocking{
      val observer : Observer<List<Group>> = Observer {
         Assert.assertEquals(2, it.size)
      }
      groupsDao.addGroup(aGroup().withId(1).build())
      groupsDao.addGroup(aGroup().withId(2).build())
      groupsDao.getGroups().observeForever(observer)
      groupsDao.getGroups().removeObserver(observer)
   }
}