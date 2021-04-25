package id.itborneo.core.utils.testing

import androidx.test.espresso.IdlingResource
import androidx.test.espresso.idling.CountingIdlingResource

/*
Instrument Testing utils
 */
object EspressoIdlingResource {
    private const val RESOURCE = "GLOBAL"
    private val espressoTestIdlingResource = CountingIdlingResource(RESOURCE)

    fun increment() {
        espressoTestIdlingResource.increment()
    }

    fun decrement() {
        espressoTestIdlingResource.decrement()
    }

    fun idlingResource(): IdlingResource {
        return espressoTestIdlingResource
    }
}