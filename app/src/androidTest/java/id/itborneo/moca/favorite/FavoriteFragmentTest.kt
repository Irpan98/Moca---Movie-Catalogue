package id.itborneo.moca.favorite

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.*
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.google.android.material.tabs.TabLayout
import id.itborneo.moca.R
import id.itborneo.moca.core.utils.testing.EspressoIdlingResource
import id.itborneo.moca.main.MainActivity
import org.hamcrest.Matchers.allOf
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class FavoriteFragmentTest {

    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource())
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource())
    }

    @Test
    fun moviesFavorite() {

        //click to movies fragment
        Espresso.onView(ViewMatchers.withId(R.id.movieFragment)).perform(ViewActions.click())

        val position = 1
        val recyclerViewTest = Espresso.onView(ViewMatchers.withId(R.id.rv_movies))
        recyclerViewTest.perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                position,
                ViewActions.click()
            )
        )

        addFavorite()
        Espresso.pressBack()

        recyclerViewTest.perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                position,
                ViewActions.click()
            )
        )
        removeFavorite()

    }

    @Test
    fun seriesFavorite() {

        //click to movies fragment
        Espresso.onView(ViewMatchers.withId(R.id.seriesFragment)).perform(ViewActions.click())

        val position = 1
        val recyclerViewTest = Espresso.onView(ViewMatchers.withId(R.id.rv_series))
        recyclerViewTest.perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                position,
                ViewActions.click()
            )
        )
        addFavorite()

        Espresso.pressBack()

        recyclerViewTest.perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                position,
                ViewActions.click()
            )
        )
        removeFavorite()
    }


    @Test
    fun openListFavorite() {

        listFavoriteMovieTest()

        Espresso.pressBack()

        listFavoriteSeriesTest()
    }

    private fun listFavoriteSeriesTest() {
        Espresso.onView(ViewMatchers.withId(R.id.favoriteFragment)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.tabs)).perform(selectTabAtPosition(1))

        val position = 0
        val recyclerViewTest = Espresso.onView(ViewMatchers.withId(R.id.rv_movies))
        recyclerViewTest.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        recyclerViewTest.perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                position,
                ViewActions.click()
            )
        )
    }


    private fun listFavoriteMovieTest() {
        Espresso.onView(ViewMatchers.withId(R.id.favoriteFragment)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.tabs)).perform(selectTabAtPosition(0))

        val position = 0
        val recyclerViewTest = Espresso.onView(ViewMatchers.withId(R.id.rv_movies))
        recyclerViewTest.perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                position,
                ViewActions.click()
            )
        )
    }


    private fun addFavorite() {
        Espresso.onView(ViewMatchers.withId(R.id.btnFavorite)).perform(ViewActions.click())
    }

    private fun removeFavorite() {
        Espresso.onView(ViewMatchers.withId(R.id.btnFavorite)).perform(ViewActions.click())
    }

    private fun selectTabAtPosition(tabIndex: Int): ViewAction {
        return object : ViewAction {
            override fun getDescription() = "with tab at index $tabIndex"

            override fun getConstraints() =
                allOf(
                    ViewMatchers.isDisplayed(),
                    ViewMatchers.isAssignableFrom(TabLayout::class.java)
                )

            override fun perform(uiController: UiController, view: View) {
                val tabLayout = view as TabLayout
                val tabAtIndex: TabLayout.Tab = tabLayout.getTabAt(tabIndex)
                    ?: throw PerformException.Builder()
                        .withCause(Throwable("No tab at index $tabIndex"))
                        .build()

                tabAtIndex.select()
            }
        }
    }


}