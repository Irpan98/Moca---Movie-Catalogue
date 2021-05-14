package id.itborneo.moca.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import id.itborneo.core.domain.usecase.MocaUseCase
import id.itborneo.core.utils.Resource
import id.itborneo.moca.dummy.DummyTestData
import id.itborneo.moca.model.MovieModel
import id.itborneo.moca.model.SeriesModel
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
    private lateinit var useCase: MocaUseCase

    @Mock
    private lateinit var seriesObserver: Observer<Resource<List<SeriesModel>>>
    @Mock
    private lateinit var movieObserver: Observer<Resource<List<MovieModel>>>


    @Before
    fun setUp() {
        viewModel = HomeViewModel(useCase)
    }

    @Test
    fun getTrendingMovieCoroutine() = runBlockingTest {

        Mockito.`when`(useCase.getTrendingMovies()).thenReturn(DummyTestData.getMovies())

        //check not null viewModel
        assertNotNull(viewModel)

        // not null movies after called
        viewModel.initData()
        assertNotNull(viewModel.getTrendingMovies())
        viewModel.getTrendingMovies().observeForever(movieObserver)

        //check title data getMovies
        assertEquals(
            viewModel.getTrendingMovies().value?.data?.get(0)?.title,
            DummyTestData.getMovies().value?.data?.get(0)?.title
        )
    }

    @Test
    fun getNowPlayingMovieCoroutine() = runBlockingTest {

        Mockito.`when`(useCase.getNowPlayingMovies()).thenReturn(DummyTestData.getMovies())

        //check not null viewModel
        assertNotNull(viewModel)

        // not null movies after called
        viewModel.initData()
        assertNotNull(viewModel.getNowPlayingMovies())
        viewModel.getNowPlayingMovies().observeForever(movieObserver)

        //check title data getMovies
        assertEquals(
            viewModel.getNowPlayingMovies().value?.data?.get(0)?.title,
            DummyTestData.getMovies().value?.data?.get(0)?.title
        )
    }

    @Test
    fun getTrendingSeriesCoroutine() = runBlockingTest {

        Mockito.`when`(useCase.getTrendingSeries()).thenReturn(DummyTestData.getSeries())

        //check not null viewModel
        assertNotNull(viewModel)

        // not null series after called
        viewModel.initData()
        assertNotNull(viewModel.getTrendingSeries())
        viewModel.getTrendingSeries().observeForever(seriesObserver)

        //check name data get Series
        assertEquals(
            viewModel.getTrendingSeries().value?.data?.get(0)?.name,
            DummyTestData.getSeries().value?.data?.get(0)?.name
        )
    }

    @Test
    fun getAiringTodaySeriesCoroutine() = runBlockingTest {

        Mockito.`when`(useCase.getAiringTodaySeries()).thenReturn(DummyTestData.getSeries())

        //check not null viewModel
        assertNotNull(viewModel)

        // not null movies after called
        viewModel.initData()
        assertNotNull(viewModel.getAiringTodaySeries())
        viewModel.getAiringTodaySeries().observeForever(seriesObserver)

        //check title data getMovies
        assertEquals(
            viewModel.getAiringTodaySeries().value?.data?.get(0)?.name,
            DummyTestData.getSeries().value?.data?.get(0)?.name
        )
    }


}