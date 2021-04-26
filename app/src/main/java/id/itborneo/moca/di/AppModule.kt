package id.itborneo.moca.di

import id.itborneo.moca.detail.viewmodels.DetailMovieViewModel
import id.itborneo.moca.detail.viewmodels.DetailSeriesViewModel
import id.itborneo.moca.home.HomeViewModel
import id.itborneo.moca.movie.MovieViewModel
import id.itborneo.moca.series.SeriesViewModel
import kotlinx.coroutines.FlowPreview
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

@FlowPreview
val viewModelModule = module {
    viewModel {
        MovieViewModel(get())
    }
    viewModel {
        HomeViewModel(get())
    }
    viewModel {
        SeriesViewModel(get())
    }

    viewModel { parameter ->
        DetailSeriesViewModel(get(), parameter.get())
    }
    viewModel { parameter ->
        DetailMovieViewModel(get(), parameter.get())
    }
}