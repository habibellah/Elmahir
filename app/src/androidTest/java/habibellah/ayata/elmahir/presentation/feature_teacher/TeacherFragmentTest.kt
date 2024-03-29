package habibellah.ayata.elmahir.presentation.feature_teacher

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.hasChildCount
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import habibellah.ayata.elmahir.R
import habibellah.ayata.elmahir.data.TeacherDataBuilder.Companion.aTeacher
import habibellah.ayata.elmahir.launchFragmentInHiltContainer
import kotlinx.coroutines.ExperimentalCoroutinesApi
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


   val teachers = listOf(
      aTeacher().withId(1).withName("habib").build(),
      aTeacher().withId(2).withName("ec").build(),
      aTeacher().withId(3).withName("ce").build(),
      aTeacher().withId(4).withName("fa").build(),
      aTeacher().withId(5).withName("af").build(),
   )
   @Before
   fun setup() {
      hiltRule.inject()
   }

   @Test
   fun testEmptyRecyclerViewWhenReturnEmptyTeacherList() {
      launchFragmentInHiltContainer<TeacherFragment> {
     this.view!!.findViewById<RecyclerView>(R.id.teachers_recycler)
            ?: throw AssertionError("RecyclerView Not Found")
      }
      onView(withId(R.id.teachers_recycler))
         .check(matches(hasChildCount(0)))
   }

   @Test
   fun testNonEmptyTeachersList(){
      launchFragmentInHiltContainer<TeacherFragment>(){
            (this as TeacherFragment).teacherAdapter.setData(teachers)
      }
      onView(withText("habib"))
         .check(matches(isDisplayed()))
   }
}