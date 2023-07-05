package habibellah.ayata.elmahir.presentation.feature_teacher

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.PerformException
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import habibellah.ayata.elmahir.R
import habibellah.ayata.elmahir.launchFragmentInHiltContainer
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.hamcrest.CoreMatchers.instanceOf
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

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
      launchFragmentInHiltContainer<TeacherFragment>()
      onView(withId(R.id.add_teacher_fab))
         .check(matches(isDisplayed()))
   }

   @Test
   fun testEmptyRecyclerViewWhenReturnEmptyTeacherList(){
      var items = 0
      launchFragmentInHiltContainer<TeacherFragment>(){
         val recycler = this.view!!.findViewById<RecyclerView>(R.id.teachers_recycler)
         items = recycler.adapter!!.itemCount
      }
      Assert.assertEquals(0,items)
   }

   @Test
   fun testItemDoesNotExistInTeacherList(){
      launchFragmentInHiltContainer<TeacherFragment>()
      onView(withId(R.id.teachers_recycler))
         .check(matches(instanceOf(RecyclerView::class.java)))

   }
}