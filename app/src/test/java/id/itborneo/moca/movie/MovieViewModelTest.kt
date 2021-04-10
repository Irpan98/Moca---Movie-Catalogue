package id.itborneo.moca.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import id.itborneo.moca.core.model.MovieModel
import id.itborneo.moca.core.model.response.MovieListResponse
import id.itborneo.moca.core.repository.MocaRepository
import id.itborneo.moca.core.utils.Resource
import junit.framework.Assert.assertNotNull
import kotlinx.coroutines.*
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: MovieViewModel

    //
    @Mock
    private lateinit var repository: MocaRepository


    @ObsoleteCoroutinesApi
    @Before
    fun setUp() {
//        repository = MocaRepository
        viewModel = MovieViewModel(repository)
        Dispatchers.setMain(mainThreadSurrogate)


    }

    @ObsoleteCoroutinesApi
    private val mainThreadSurrogate = newSingleThreadContext("UI thread")


    @ObsoleteCoroutinesApi
    @After
    fun tearDown() {
        Dispatchers.resetMain() // reset main dispatcher to the original Main dispatcher
        mainThreadSurrogate.close()
    }

//
//    //    @Mock
//    private lateinit var dummyMovie2: LiveData<Resource<MovieListResponse>>
//
//    @Mock
//    private lateinit var observer: Observer<Resource<MovieListResponse>>
//
//    private lateinit var dummyMovie: LiveData<Resource<MovieListResponse>>


    @ExperimentalCoroutinesApi
    @Test

    fun getMovieCoroutine() = runBlockingTest {

        launch {

            val dummyMovie2 = MutableLiveData<Resource<MovieListResponse>>()
            dummyMovie2.value = Resource.success(
                MovieListResponse(results = listOf(MovieModel()))
            )

            Mockito.`when`(repository.getMovies()).thenReturn(dummyMovie2)
//        assertEquals(repository.getMovies().value, dummyMovie2)
            assertNotNull(viewModel)
            viewModel.initMovies()
            assertNotNull(viewModel.getMovies())
        }
    }

//    @Test
//    fun getMovie() {
////        coroutineR
////        viewModel = MovieViewModel(repository)
//
//        dummyMovie2 = MutableLiveData<Resource<MovieListResponse>>()
////        dummyMovie2.value = Resource.success(
////            MovieListResponse(results = listOf(MovieModel()))
////        )
//
////        Mockito.`when`(repository.getMovies()).thenReturn(dummyMovie2)
////        Mockito.verify(repository).getMovies()
////        assertEquals (repository.getMovies().value,dummyMovie2)
//
//
////        Mockito.verify(repository).getMovies()
//        assertNotNull(viewModel)
//        assertNotNull(viewModel.getMovies())
//
//        assertEquals(viewModel.getMovies().value?.data, dummyMovie2)
//
////        assertNotNull(repository.getMovies())
//
//
////        val dummyMovies = dummymovie
////        val dummyListMovies = MutableLiveData<Resource<PagedList<MovieEntity>>>()
////        dummyListMovies.value = dummyMovies
////
////        Mockito.`when`(repository.getMovies()).thenReturn(dummyListMovies)
////        val movies = viewModel.getMovies()
////        // memastikan repository di panggil
////        Mockito.verify<Repository>(repository).getMovies()
////
////        //memastikan item yg didapat tidak null
////        assertNotNull(movies)
////
////        //memastikan jumlah item sesuati yg diinput
////        assertEquals(5, movies.value?.data?.size)
////
////        viewModel.getMovies().observeForever(observer)
////        Mockito.verify(observer).onChanged(dummyMovies)
//
//    }
}