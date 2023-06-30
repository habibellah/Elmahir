package habibellah.ayata.elmahir.presentation.feature_teacher

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.filters.SmallTest
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import habibellah.ayata.elmahir.launchFragmentInHiltContainer
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@ExperimentalCoroutinesApi
@SmallTest
@HiltAndroidTest
class TeacherFragmentTest {


   @get:Rule
   var hiltRule = HiltAndroidRule(this)

   // single task rule
   @get:Rule
   var instantTaskExecutorRule = InstantTaskExecutorRule()

   @Before
   fun setup() {
      hiltRule.inject()
   }

   @Test
   fun testLaunchFragmentHiltContainer(){
      launchFragmentInHiltContainer<TeacherFragment>{

      }
   }
}