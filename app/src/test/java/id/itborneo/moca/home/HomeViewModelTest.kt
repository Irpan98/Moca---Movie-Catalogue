package id.itborneo.moca.home

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

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class HomeViewModelTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: HomeViewModel

    @Mock
    private lateinit var repository: MocaRepository

    @Before
    fun setUp() {
        viewModel = HomeViewModel(repository)
    }

    @Test
    fun getTrendingMovieCoroutine() = runBlockingTest {

        Mockito.`when`(repository.getTrendingMovies()).thenReturn(DummyTestData.getMovies())

        //check not null viewModel
        assertNotNull(viewModel)

        // not null movies after called
        viewModel.initData()
        assertNotNull(viewModel.getTrendingMovies())

        //check title data getMovies
        assertEquals(
            viewModel.getTrendingMovies().value?.data?.results?.get(0)?.title,
            DummyTestData.getMovies().value?.data?.results?.get(0)?.title
        )
    }

    @Test
    fun getNowPlayingMovieCoroutine() = runBlockingTest {

        Mockito.`when`(repository.getNowPlayingMovies()).thenReturn(DummyTestData.getMovies())

        //check not null viewModel
        assertNotNull(viewModel)

        // not null movies after called
        viewModel.initData()
        assertNotNull(viewModel.getNowPlayingMovies())

        //check title data getMovies
        assertEquals(
            viewModel.getNowPlayingMovies().value?.data?.results?.get(0)?.title,
            DummyTestData.getMovies().value?.data?.results?.get(0)?.title
        )
    }

    @Test
    fun getTrendingSeriesCoroutine() = runBlockingTest {

        Mockito.`when`(repository.getTrendingSeries()).thenReturn(DummyTestData.getSeries())

        //check not null viewModel
        assertNotNull(viewModel)

        // not null movies after called
        viewModel.initData()
        assertNotNull(viewModel.getTrendingSeries())

        //check title data getMovies
        assertEquals(
            viewModel.getTrendingSeries().value?.data?.results?.get(0)?.name,
            DummyTestData.getSeries().value?.data?.results?.get(0)?.name
        )
    }

    @Test
    fun getAiringTodaySeriesCoroutine() = runBlockingTest {

        Mockito.`when`(repository.getAiringTodaySeries()).thenReturn(DummyTestData.getSeries())

        //check not null viewModel
        assertNotNull(viewModel)

        // not null movies after called
        viewModel.initData()
        assertNotNull(viewModel.getAiringTodaySeries())

        //check title data getMovies
        assertEquals(
            viewModel.getAiringTodaySeries().value?.data?.results?.get(0)?.name,
            DummyTestData.getSeries().value?.data?.results?.get(0)?.name
        )
    }


}