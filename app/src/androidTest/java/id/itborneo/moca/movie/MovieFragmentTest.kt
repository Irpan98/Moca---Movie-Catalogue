package id.itborneo.moca.movie

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import id.itborneo.core.utils.testing.EspressoIdlingResource
import id.itborneo.moca.R
import id.itborneo.moca.main.MainActivity
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MovieFragmentTest {

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
    fun loadMovies() {

        //click to movies fragment
        Espresso.onView(ViewMatchers.withId(R.id.movieFragment)).perform(ViewActions.click())

        val position = 4
        val recyclerViewTest = Espresso.onView(ViewMatchers.withId(R.id.rv_movies))

        //show recyclerview
        recyclerViewTest.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        //scroll
        recyclerViewTest.perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                position
            )
        )

        //click to detail
        recyclerViewTest.perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                position,
                ViewActions.click()
            )
        )

        //detail
        checkDetail()
    }

    private fun checkDetail() {

        val tvTitle = Espresso.onView(ViewMatchers.withId(R.id.tv_detail_movie_title))
        tvTitle.perform(ViewActions.scrollTo())
        tvTitle.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        val tvGenres = Espresso.onView(ViewMatchers.withId(R.id.tv_detail_movie_genres))
        tvGenres.perform(ViewActions.scrollTo())
        tvGenres.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        val tvVoteAverage = Espresso.onView(ViewMatchers.withId(R.id.tv_detail_movie_vote_average))
        tvVoteAverage.perform(ViewActions.scrollTo())
        tvVoteAverage.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        val tvOverview = Espresso.onView(ViewMatchers.withId(R.id.tv_detail_movie_overview))
        tvOverview.perform(ViewActions.scrollTo())
        tvOverview.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        val rvCasts = Espresso.onView(ViewMatchers.withId(R.id.rv_detail_movie_casts))
        rvCasts.perform(ViewActions.scrollTo())
        rvCasts.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

    }


}
