package id.itborneo.moca.favorite

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.swipeLeft
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import id.itborneo.moca.R
import id.itborneo.moca.core.utils.testing.EspressoIdlingResource
import id.itborneo.moca.main.MainActivity
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
    fun movieAddRemoveFavorite() {

        val position = 1
        val recyclerViewTest = Espresso.onView(ViewMatchers.withId(R.id.rv_movies))

        Espresso.onView(ViewMatchers.withId(R.id.movieFragment)).perform(ViewActions.click())
        recyclerViewTest.perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                position,
                ViewActions.click()
            )
        )

        addFavorite()
        Espresso.pressBack()
        listFavoriteMovieTest()
        Espresso.pressBack()
        Espresso.onView(ViewMatchers.withId(R.id.movieFragment)).perform(ViewActions.click())


        recyclerViewTest.perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                position,
                ViewActions.click()
            )
        )
        removeFavorite()

    }

    @Test
    fun seriesAddRemoveFavorite() {

        val position = 1
        val recyclerViewTest = Espresso.onView(ViewMatchers.withId(R.id.rv_series))

        Espresso.onView(ViewMatchers.withId(R.id.seriesFragment)).perform(ViewActions.click())
        recyclerViewTest.perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                position,
                ViewActions.click()
            )
        )

        addFavorite()
        Espresso.pressBack()
        listFavoriteSeriesTest()
        Espresso.pressBack()

        Espresso.onView(ViewMatchers.withId(R.id.seriesFragment)).perform(ViewActions.click())
        recyclerViewTest.perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                position,
                ViewActions.click()
            )
        )
        removeFavorite()
    }

    private fun listFavoriteSeriesTest() {
        Espresso.onView(ViewMatchers.withId(R.id.favoriteFragment)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.view_pager)).perform(swipeLeft())
        Espresso.onView(ViewMatchers.withId(R.id.rv_series))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    0,
                    ViewActions.click()
                )
            )
    }

    private fun listFavoriteMovieTest() {
        Espresso.onView(ViewMatchers.withId(R.id.favoriteFragment)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.rv_movies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
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


}