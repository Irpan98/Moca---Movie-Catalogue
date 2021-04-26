package id.itborneo.moca.detail

//import androidx.arch.core.executor.testing.InstantTaskExecutorRule
//import id.itborneo.moca.core.repository.MocaRepository
//import id.itborneo.moca.detail.viewmodel.DetailMovieViewModel
//import id.itborneo.moca.dummy.DummyTestData
//import kotlinx.coroutines.ExperimentalCoroutinesApi
//import kotlinx.coroutines.test.runBlockingTest
//import org.junit.Assert.assertEquals
//import org.junit.Assert.assertNotNull
//import org.junit.Before
//import org.junit.Rule
//import org.junit.Test
//import org.junit.runner.RunWith
//import org.mockito.Mock
//import org.mockito.Mockito
//import org.mockito.junit.MockitoJUnitRunner
//
//@ExperimentalCoroutinesApi
//@RunWith(MockitoJUnitRunner::class)
//class DetailMovieViewModelTest {
//    @get:Rule
//    val instantTaskExecutorRule = InstantTaskExecutorRule()
//
//    private lateinit var viewModel: DetailMovieViewModel
//
//    @Mock
//    private lateinit var repository: MocaRepository
//
//    @Before
//    fun setUp() {
//        viewModel = DetailMovieViewModel(
//            repository,
//            1
//        )
//    }
//
//    @Test
//    fun getDetailMovieCoroutine() = runBlockingTest {
//
//        Mockito.`when`(repository.getDetailMovie(1)).thenReturn(DummyTestData.getDetailMovie())
//
//        //check not null viewModel
//        assertNotNull(viewModel)
//
//        // not null movies after getDetailMovie
//        viewModel.initDetailMovie()
//        assertNotNull(viewModel.getDetailMovie())
//
//        //check data get detail movie
//        assertEquals(
//            viewModel.getDetailMovie().value?.data,
//            DummyTestData.getDetailMovie().value?.data
//        )
//    }
//
//
//    @Test
//    fun getErrorMovieCoroutine() = runBlockingTest {
//
//        Mockito.`when`(repository.getDetailMovie(1)).thenReturn(DummyTestData.getDetailMoviesError())
//        viewModel.initDetailMovie()
//
//        //check message, should get error message
//        assertEquals(
//            DummyTestData.getMoviesError().value?.message,
//            viewModel.getDetailMovie().value?.message,
//        )
//    }
//}
