package id.itborneo.moca.main

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import id.itborneo.moca.R
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun loadMain() {

        //check bottom nav
        onView(withId(R.id.bottom_nav)).check(matches(isDisplayed()))

        //check fragment container
        onView(withId(R.id.movieFragment)).check(matches(isDisplayed()))
        onView(withId(R.id.seriesFragment)).check(matches(isDisplayed()))
        onView(withId(R.id.favoriteFragment)).check(matches(isDisplayed()))

    }
}
