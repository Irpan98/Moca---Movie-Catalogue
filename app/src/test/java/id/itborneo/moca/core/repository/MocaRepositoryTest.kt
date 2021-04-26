package id.itborneo.moca.core.repository

//@ExperimentalCoroutinesApi
//@RunWith(MockitoJUnitRunner::class)
//class RMocaRepositoryTest {
//
//    @get:Rule
//    val instantTaskExecutorRule = InstantTaskExecutorRule()
//
//
//    private val remote = Mockito.mock(RemoteDataSource::class.java)
//    private val local = Mockito.mock(LocalDataSource::class.java)
//
//    private val mocaRepository = MocaRepository(remote, local)
//
//    @Test
//    fun getMovies() = runBlockingTest {
//        val dummyMovies = DummyTestData.getMovies()
//        Mockito.`when`(remote.getMovies()).thenReturn(dummyMovies)
//        val getMovies = mocaRepository.getMovies()
//        verify(remote).getMovies()
//        assertNotNull(getMovies)
//        assertEquals(dummyMovies, getMovies)
//    }
//
//    @Test
//    fun getSeries() = runBlockingTest {
//        val dummySeries = DummyTestData.getSeries()
//        Mockito.`when`(remote.getSeries()).thenReturn(dummySeries)
//        val getSeries = mocaRepository.getSeries()
//        verify(remote).getSeries()
//        assertNotNull(getSeries)
//        assertEquals(dummySeries, getSeries)
//    }
//
//    @Test
//    fun getTrendingMovie() = runBlockingTest {
//
//        val dummyTrendingMovies = DummyTestData.getMovies()
//        Mockito.`when`(remote.getTrendingMovies())
//            .thenReturn(dummyTrendingMovies)
//        val getDummyMovies = mocaRepository.getTrendingMovies()
//        verify(remote).getTrendingMovies()
//        assertNotNull(getDummyMovies)
//        assertEquals(dummyTrendingMovies, getDummyMovies)
//    }
//
//    @Test
//    fun getTrendingSeries() = runBlockingTest {
//
//        val dummyTrendingSeries = DummyTestData.getSeries()
//        Mockito.`when`(remote.getTrendingSeries())
//            .thenReturn(dummyTrendingSeries)
//        val getDummySeries = mocaRepository.getTrendingSeries()
//        verify(remote).getTrendingSeries()
//        assertNotNull(getDummySeries)
//        assertEquals(dummyTrendingSeries, getDummySeries)
//    }
//
//
//
//    @Test
//    fun getNowPlayingMovies() = runBlockingTest {
//
//        val dummyNowPlayingMovies = DummyTestData.getMovies()
//        Mockito.`when`(remote.getNowPlayingMovies())
//            .thenReturn(dummyNowPlayingMovies)
//        val getDummyMovies = mocaRepository.getNowPlayingMovies()
//        verify(remote).getNowPlayingMovies()
//        assertNotNull(getDummyMovies)
//        assertEquals(dummyNowPlayingMovies, getDummyMovies)
//    }
//
//    @Test
//    fun getAiringTodaySeries() = runBlockingTest {
//
//        val dummyAiringTodaySeries = DummyTestData.getSeries()
//        Mockito.`when`(remote.getAiringTodaySeries())
//            .thenReturn(dummyAiringTodaySeries)
//        val getDummySeries = mocaRepository.getAiringTodaySeries()
//        verify(remote).getAiringTodaySeries()
//        assertNotNull(getDummySeries)
//        assertEquals(dummyAiringTodaySeries, getDummySeries)
//    }
//
//    @Test
//    fun getDetailMovie() = runBlockingTest {
//
//        val dummyDetailMovie = DummyTestData.getDetailMovie()
//        val id = dummyDetailMovie.value?.data?.id ?: 0
//        Mockito.`when`(remote.getDetailMovie(id))
//            .thenReturn(dummyDetailMovie)
//        val getDummyMovie = mocaRepository.getDetailMovie(id)
//        verify(remote).getDetailMovie(id)
//        assertNotNull(getDummyMovie)
//        assertEquals(dummyDetailMovie, getDummyMovie)
//    }
//
//    @Test
//    fun getDetailSeries() = runBlockingTest {
//
//        val dummyDetailSeries = DummyTestData.getDetailSeries()
//        val id = dummyDetailSeries.value?.data?.id ?: 0
//        Mockito.`when`(remote.getDetailSeries(id))
//            .thenReturn(dummyDetailSeries)
//        val getDummySeries = mocaRepository.getDetailSeries(id)
//        verify(remote).getDetailSeries(id)
//        assertNotNull(getDummySeries)
//        assertEquals(dummyDetailSeries, getDummySeries)
//    }
//
//
//    @Test
//    fun getCredits() = runBlockingTest {
//
//        val dummyCredits = DummyTestData.getCredits()
//        val id = dummyCredits.value?.data?.id ?: 0
//        Mockito.`when`(remote.getCredits(id))
//            .thenReturn(dummyCredits)
//        val getDummySeries = mocaRepository.getCredits(id)
//        verify(remote).getCredits(id)
//        assertNotNull(getDummySeries)
//        assertEquals(dummyCredits, getDummySeries)
//    }
//
//
//    @Test
//    fun getSingleMovieFavorite() = runBlockingTest {
//
//        val dummySingleMovieFavorite = DummyTestData.getSingleFavoriteMovie()
//        val id = dummySingleMovieFavorite.id
//        Mockito.`when`(local.getSingleMovieFavorite(id))
//            .thenReturn(dummySingleMovieFavorite)
//        val getDummySeries = mocaRepository.getSingleMovieFavorite(id)
//        verify(local).getSingleMovieFavorite(id)
//        assertNotNull(getDummySeries)
//        assertEquals(dummySingleMovieFavorite, getDummySeries)
//    }
//
//    @Test
//    fun getSingleSeriesFavorite() = runBlockingTest {
//
//        val dummySingleSeriesFavorite = DummyTestData.getSingleFavoriteSeries()
//        val id = dummySingleSeriesFavorite.id
//        Mockito.`when`(local.getSingleSeriesFavorite(id))
//            .thenReturn(dummySingleSeriesFavorite)
//        val getDummySeries = mocaRepository.getSingleSeriesFavorite(id)
//        verify(local).getSingleSeriesFavorite(id)
//        assertNotNull(getDummySeries)
//        assertEquals(dummySingleSeriesFavorite, getDummySeries)
//    }
//
//
//    @Test
//    fun searchMovies() = runBlockingTest {
//        val dummySearchMovies = DummyTestData.getMovies()
//        Mockito.`when`(remote.searchMovies("")).thenReturn(dummySearchMovies)
//        val searchMovies = mocaRepository.searchMovies("")
//        verify(remote).searchMovies("")
//        assertNotNull(searchMovies)
//        assertEquals(dummySearchMovies, searchMovies)
//    }
//
//    @Test
//    fun searchSeries() = runBlockingTest {
//        val dummySearchSeries = DummyTestData.getSeries()
//        Mockito.`when`(remote.searchSeries("")).thenReturn(dummySearchSeries)
//        val searchSeries = mocaRepository.searchSeries("")
//        verify(remote).searchSeries("")
//        assertNotNull(searchSeries)
//        assertEquals(dummySearchSeries, searchSeries)
//    }
//
//
//}