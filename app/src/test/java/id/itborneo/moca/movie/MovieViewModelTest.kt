package id.itborneo.moca.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import id.itborneo.moca.core.repository.MocaRepository
import id.itborneo.moca.dummy.DummyTestData
import kotlinx.coroutines.ExperimentalCoroutinesApi
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

//@ExperimentalCoroutinesApi
//@RunWith(MockitoJUnitRunner::class)
//class MovieViewModelTest {
//
//    @get:Rule
//    val instantTaskExecutorRule = InstantTaskExecutorRule()
//
//    private lateinit var viewModel: MovieViewModel
//
//    @Mock
//    private lateinit var repository: MocaRepository
//
//    @Before
//    fun setUp() {
//        viewModel = MovieViewModel(repository)
//    }
//
//    @Test
//    fun getMovieCoroutine() = runBlockingTest {
//
//        Mockito.`when`(repository.getMovies()).thenReturn(DummyTestData.getMovies())
//
//        //check not null viewModel
//        assertNotNull(viewModel)
//
//        // not null movies after called
//        viewModel.initMovies()
//        assertNotNull(viewModel.getMovies())
//
//        //check title data getMovies
//        assertEquals(
//            viewModel.getMovies().value?.data?.results?.get(0)?.title,
//            DummyTestData.getMovies().value?.data?.results?.get(0)?.title
//        )
//    }
//
//    @Test
//    fun getEmptyMovieCoroutine() = runBlockingTest {
//
//        Mockito.`when`(repository.getMovies()).thenReturn(DummyTestData.getMoviesEmpty())
//        viewModel.initMovies()
//
//        //check size data should be 0
//        assertEquals(
//            0,
//            viewModel.getMovies().value?.data?.results?.size,
//        )
//    }
//
//    @Test
//    fun getErrorMovieCoroutine() = runBlockingTest {
//
//        Mockito.`when`(repository.getMovies()).thenReturn(DummyTestData.getMoviesError())
//        viewModel.initMovies()
//
//        //check message, should get error message
//        assertEquals(
//            DummyTestData.getMoviesError().value?.message,
//            viewModel.getMovies().value?.message,
//        )
//    }
//
//}