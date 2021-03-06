package id.itborneo.moca.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import id.itborneo.core.domain.usecase.MocaUseCase
import id.itborneo.moca.dummy.DummyTestData
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@FlowPreview
@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: MovieViewModel

    @Mock
    private lateinit var useCase: MocaUseCase

    @Before
    fun setUp() {
        viewModel = MovieViewModel(useCase)
    }

    @Test
    fun getMovie() = runBlockingTest {

        Mockito.`when`(useCase.getMovies()).thenReturn(DummyTestData.getMovies())

        //check not null viewModel
        assertNotNull(viewModel)

        // not null movies after called
        viewModel.initMovies()
        val movies = viewModel.getMovies()

        assertNotNull(movies)

        assertEquals(
            DummyTestData.getMovies().value,
            movies.value,
        )
    }

    @Test
    fun getEmptyMovieCoroutine() = runBlockingTest {

        Mockito.`when`(useCase.getMovies()).thenReturn(DummyTestData.getMoviesEmpty())
        viewModel.initMovies()

        //check size data should be 0
        assertEquals(
            0,
            viewModel.getMovies().value?.data?.size,
        )
    }

    @Test
    fun getErrorMovieCoroutine() = runBlockingTest {

        Mockito.`when`(useCase.getMovies()).thenReturn(DummyTestData.getMovies())

        Mockito.`when`(useCase.getMovies()).thenReturn(DummyTestData.getMoviesError())
        viewModel.initMovies()

        //check message, should get error message
        assertEquals(
            DummyTestData.getMoviesError().value?.message,
            viewModel.getMovies().value?.message,
        )
    }

}