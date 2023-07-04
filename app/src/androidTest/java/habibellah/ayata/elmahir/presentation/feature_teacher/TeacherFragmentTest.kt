package habibellah.ayata.elmahir.presentation.feature_teacher

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import habibellah.ayata.elmahir.launchFragmentInHiltContainer
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import habibellah.ayata.elmahir.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(AndroidJUnit4::class)
@ExperimentalCoroutinesApi
@SmallTest
@HiltAndroidTest
class TeacherFragmentTest {


   @get:Rule
   var hiltRule = HiltAndroidRule(this)

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