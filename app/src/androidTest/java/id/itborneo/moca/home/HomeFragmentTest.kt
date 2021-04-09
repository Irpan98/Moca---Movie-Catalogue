package id.itborneo.moca.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import id.itborneo.moca.R
import id.itborneo.moca.core.utils.testing.EspressoIdlingResource
import id.itborneo.moca.main.MainActivity
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeFragmentTest{
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
    fun loadHomeTrendingMovies() {
        checkRecyclerview(R.id.rv_home_movies, 3)
    }

    @Test
    fun loadHomeTrendingSeries() {
        checkRecyclerview(R.id.rv_home_series, 2)
    }

    @Test
    fun loadHomeNowPlayingMovies() {
        checkRecyclerview(R.id.rv_now_playing_movies, 4)
    }

    @Test
    fun loadHomeAiringToday() {
        checkRecyclerview(R.id.rv_airing_today_series, 4)
    }


    private fun checkRecyclerview(recyclerview: Int, position: Int) {
        val recyclerViewTest = Espresso.onView(ViewMatchers.withId(recyclerview))
        recyclerViewTest.perform(ViewActions.scrollTo())
        recyclerViewTest.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        recyclerViewTest.perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                position
            )
        )
        recyclerViewTest.perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                position,
                ViewActions.click()
            )
        )
    }
}
