package id.itborneo.moca.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import id.itborneo.core.domain.usecase.MocaUseCase
import id.itborneo.moca.detail.viewmodels.DetailSeriesViewModel
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
class DetailSeriesViewModelTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: DetailSeriesViewModel

    @Mock
    private lateinit var useCase: MocaUseCase

    @Before
    fun setUp() {
        viewModel = DetailSeriesViewModel(
            useCase,
            1
        )
    }

    @Test
    fun getDetailSeriesCoroutine() = runBlockingTest {

        Mockito.`when`(useCase.getDetailSeries(1)).thenReturn(DummyTestData.getDetailSeries())

        //check not null viewModel
        assertNotNull(viewModel)

        // not null movies after getDetailMovie
        viewModel.initDetailSeries()
        assertNotNull(viewModel.getDetail())

        //check data get detail movie
        assertEquals(
            viewModel.getDetail().value?.data,
            DummyTestData.getDetailSeries().value?.data
        )
    }


    @Test
    fun getErrorMovieCoroutine() = runBlockingTest {

        Mockito.`when`(useCase.getDetailSeries(1))
            .thenReturn(DummyTestData.getDetailSeriesError())
        viewModel.initDetailSeries()

        //check message, should get error message
        assertEquals(
            DummyTestData.getDetailSeriesError().value?.message,
            viewModel.getDetail().value?.message,
        )
    }
}
