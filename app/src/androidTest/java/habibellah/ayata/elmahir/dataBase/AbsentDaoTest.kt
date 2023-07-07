package habibellah.ayata.elmahir.dataBase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import habibellah.ayata.elmahir.data.AbsentDataBuilder.Companion.anAbsent
import habibellah.ayata.elmahir.data.roomDb.AbsentDao
import habibellah.ayata.elmahir.data.roomDb.ElmahirDataBase
import habibellah.ayata.elmahir.data.roomDb.entity.Absent
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@HiltAndroidTest
class AbsentDaoTest {
   @get:Rule
   val hiltRule = HiltAndroidRule(this)

   @get:Rule
   var instantTaskExecutorRule = InstantTaskExecutorRule()

   @Inject
   lateinit var elmahirDataBase : ElmahirDataBase
   private lateinit var absentDao : AbsentDao

   @Before
   fun initDb() {
      hiltRule.inject()
      absentDao = elmahirDataBase.absentDao()
   }

   @After
   fun closeDb() {
      elmahirDataBase.close()
   }

   @Test
   fun testAddAbsentByStudentId() = runBlocking {
      val observer : Observer<List<Absent>> = Observer {
         Assert.assertEquals(2 , it.size)
      }
      absentDao.addAbsent(anAbsent().withId(1).withStudentId(2).build())
      absentDao.addAbsent(anAbsent().withId(2).withStudentId(2).build())
      absentDao.getAbsentsBy(2).observeForever(observer)
      absentDao.getAbsentsBy(2).removeObserver(observer)
   }

   @Test
   fun testGetAbsentByStudentId() = runBlocking {
      val observer : Observer<List<Absent>> = Observer {
         Assert.assertEquals(3 , it.size)
      }
      absentDao.addAbsent(anAbsent().withId(1).withStudentId(2).build())
      absentDao.addAbsent(anAbsent().withId(2).withStudentId(2).build())
      absentDao.addAbsent(anAbsent().withId(3).withStudentId(2).build())
      absentDao.getAbsentsBy(2).observeForever(observer)
      absentDao.getAbsentsBy(2).removeObserver(observer)
   }
}