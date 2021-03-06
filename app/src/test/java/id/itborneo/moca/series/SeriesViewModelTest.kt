package id.itborneo.moca.series

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
class SeriesViewModelTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: SeriesViewModel

    @Mock
    private lateinit var useCase: MocaUseCase

    @Before
    fun setUp() {
        viewModel = SeriesViewModel(useCase)
    }

    @Test
    fun getSeriesCoroutine() = runBlockingTest {

        Mockito.`when`(useCase.getSeries()).thenReturn(DummyTestData.getSeries())

        //check not null viewModel
        assertNotNull(viewModel)

        // not null series after called
        viewModel.initSeries()
        assertNotNull(viewModel.getSeries())

        //check title data getSeries
        assertEquals(
            viewModel.getSeries().value?.data?.get(0)?.name,
            DummyTestData.getSeries().value?.data?.get(0)?.name
        )
    }

    @Test
    fun getEmptySeriesCoroutine() = runBlockingTest {

        Mockito.`when`(useCase.getSeries()).thenReturn(DummyTestData.getSeriesEmpty())
        viewModel.initSeries()

        //check size data should be 0
        assertEquals(
            0,
            viewModel.getSeries().value?.data?.size,
        )
    }

    @Test
    fun getErrorMovieCoroutine() = runBlockingTest {

        Mockito.`when`(useCase.getSeries()).thenReturn(DummyTestData.getSeriesError())
        viewModel.initSeries()

        //check data, should have error message
        assertEquals(
            DummyTestData.getSeriesError().value?.message,
            viewModel.getSeries().value?.message,
        )
    }

}