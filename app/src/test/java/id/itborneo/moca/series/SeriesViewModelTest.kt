package id.itborneo.moca.series

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
class SeriesViewModelTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: SeriesViewModel

    @Mock
    private lateinit var repository: MocaRepository

    @Before
    fun setUp() {
        viewModel = SeriesViewModel(repository)
    }

    @Test
    fun getSeriesCoroutine() = runBlockingTest {

        Mockito.`when`(repository.getSeries()).thenReturn(DummyTestData.getSeries())

        //check not null viewModel
        assertNotNull(viewModel)

        // not null series after called
        viewModel.initSeries()
        assertNotNull(viewModel.getSeries())

        //check title data getSeries
        assertEquals(
            viewModel.getSeries().value?.data?.results?.get(0)?.name,
            DummyTestData.getSeries().value?.data?.results?.get(0)?.name
        )
    }

}