package habibellah.ayata.elmahir.presentation.feature_student

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import habibellah.ayata.elmahir.R
import habibellah.ayata.elmahir.data.GroupDataBuilder.Companion.aGroup
import habibellah.ayata.elmahir.launchFragmentInHiltContainer
import habibellah.ayata.elmahir.presentation.feature_student.groups.GroupFragment
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@ExperimentalCoroutinesApi
@HiltAndroidTest
class GroupFragmentTest {

   @get:Rule
   var hiltRule = HiltAndroidRule(this)

   @get:Rule
   var instantTaskExecutorRule = InstantTaskExecutorRule()

   private val groups = listOf(
      aGroup().withGroupName("old").build(),
      aGroup().withGroupName("young").build(),
      aGroup().withGroupName("women").build(),
   )
   @Before
   fun setup() {
      hiltRule.inject()
   }

   @Test
   fun testEmptyRecyclerViewWhenReturnEmptyGroupList() {
      launchFragmentInHiltContainer<GroupFragment> {
         this.view!!.findViewById<RecyclerView>(R.id.recycler_group)
            ?: throw AssertionError("RecyclerView Not Found")
      }
      onView(withId(R.id.recycler_group))
         .check(matches(ViewMatchers.hasChildCount(0)))
   }

   @Test
   fun testNonEmptyTeachersList(){
      launchFragmentInHiltContainer<GroupFragment>(){
         (this as GroupFragment).groupAdapter.setData(groups)
      }
      onView(ViewMatchers.withText("old"))
         .check(matches(isDisplayed()))
   }
}