package id.itborneo.moca.core.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.asFlow
import com.nhaarman.mockitokotlin2.verify
import id.itborneo.core.data.MocaRepository
import id.itborneo.core.data.local.LocalDataSource
import id.itborneo.core.data.remote.RemoteDataSource
import id.itborneo.moca.dummy.DummyTestData
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class MocaRepositoryTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()


    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val local = Mockito.mock(LocalDataSource::class.java)

    private val mocaRepository = MocaRepository(remote, local)

    @Test
    fun getMovies() = runBlockingTest {
        val dummyMovies = DummyTestData.getMovies().asFlow()
        Mockito.`when`(remote.getMovies()).thenReturn(dummyMovies)
        val getMovies = mocaRepository.getMovies()
        verify(remote).getMovies()
        assertNotNull(getMovies)
        assertEquals(dummyMovies, getMovies)
    }

    @Test
    fun getSeries() = runBlockingTest {
        val dummySeries = DummyTestData.getSeries().asFlow()
        Mockito.`when`(remote.getSeries()).thenReturn(dummySeries)
        val getSeries = mocaRepository.getSeries()
        verify(remote).getSeries()
        assertNotNull(getSeries)
        assertEquals(dummySeries, getSeries)
    }

    @Test
    fun getTrendingMovie() = runBlockingTest {

        val dummyTrendingMovies = DummyTestData.getMovies().asFlow()
        Mockito.`when`(remote.getTrendingMovies())
            .thenReturn(dummyTrendingMovies)
        val getDummyMovies = mocaRepository.getTrendingMovies()
        verify(remote).getTrendingMovies()
        assertNotNull(getDummyMovies)
        assertEquals(dummyTrendingMovies, getDummyMovies)
    }

    @Test
    fun getTrendingSeries() = runBlockingTest {

        val dummyTrendingSeries = DummyTestData.getSeries().asFlow()
        Mockito.`when`(remote.getTrendingSeries())
            .thenReturn(dummyTrendingSeries)
        val getDummySeries = mocaRepository.getTrendingSeries()
        verify(remote).getTrendingSeries()
        assertNotNull(getDummySeries)
        assertEquals(dummyTrendingSeries, getDummySeries)
    }


    @Test
    fun getNowPlayingMovies() = runBlockingTest {

        val dummyNowPlayingMovies = DummyTestData.getMovies().asFlow()
        Mockito.`when`(remote.getNowPlayingMovies())
            .thenReturn(dummyNowPlayingMovies)
        val getDummyMovies = mocaRepository.getNowPlayingMovies()
        verify(remote).getNowPlayingMovies()
        assertNotNull(getDummyMovies)
        assertEquals(dummyNowPlayingMovies, getDummyMovies)
    }

    @Test
    fun getAiringTodaySeries() = runBlockingTest {

        val dummyAiringTodaySeries = DummyTestData.getSeries().asFlow()
        Mockito.`when`(remote.getAiringTodaySeries())
            .thenReturn(dummyAiringTodaySeries)
        val getDummySeries = mocaRepository.getAiringTodaySeries()
        verify(remote).getAiringTodaySeries()
        assertNotNull(getDummySeries)
        assertEquals(dummyAiringTodaySeries, getDummySeries)
    }

    @Test
    fun getDetailMovie() = runBlockingTest {

        val dummyDetailMovie = DummyTestData.getDetailMovie().asFlow()
        val id = 2
        Mockito.`when`(remote.getDetailMovie(id))
            .thenReturn(dummyDetailMovie)
        val getDummyMovie = mocaRepository.getDetailMovie(id)
        verify(remote).getDetailMovie(id)
        assertNotNull(getDummyMovie)
        assertEquals(dummyDetailMovie, getDummyMovie)
    }

    @Test
    fun getDetailSeries() = runBlockingTest {

        val dummyDetailSeries = DummyTestData.getDetailSeries().asFlow()
        val id = 1
        Mockito.`when`(remote.getDetailSeries(id))
            .thenReturn(dummyDetailSeries)
        val getDummySeries = mocaRepository.getDetailSeries(id)
        verify(remote).getDetailSeries(id)
        assertNotNull(getDummySeries)
        assertEquals(dummyDetailSeries, getDummySeries)
    }


    @Test
    fun getCredits() = runBlockingTest {

        val dummyCredits = DummyTestData.getCredits().asFlow()
        val id = 1
        Mockito.`when`(remote.getCredits(id))
            .thenReturn(dummyCredits)
        val getCredits = mocaRepository.getCredits(id)
        verify(remote).getCredits(id)
        assertNotNull(getCredits)
        assertEquals(dummyCredits, getCredits)
    }


    @Test
    fun searchMovies() = runBlockingTest {
        val dummySearchMovies = DummyTestData.getMovies().asFlow()
        Mockito.`when`(remote.searchMovies("")).thenReturn(dummySearchMovies)
        val searchMovies = mocaRepository.searchMovies("")
        verify(remote).searchMovies("")
        assertNotNull(searchMovies)
        assertEquals(dummySearchMovies, searchMovies)
    }

    @Test
    fun searchSeries() = runBlockingTest {
        val dummySearchSeries = DummyTestData.getSeries().asFlow()
        Mockito.`when`(remote.searchSeries("")).thenReturn(dummySearchSeries)
        val searchSeries = mocaRepository.searchSeries("")
        verify(remote).searchSeries("")
        assertNotNull(searchSeries)
        assertEquals(dummySearchSeries, searchSeries)
    }


}