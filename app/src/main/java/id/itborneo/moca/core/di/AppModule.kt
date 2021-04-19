package id.itborneo.moca.core.di

import id.itborneo.moca.detail.DetailMovieViewModel
import id.itborneo.moca.detail.DetailSeriesViewModel
import id.itborneo.moca.home.HomeViewModel
import id.itborneo.moca.movie.MovieViewModel
import id.itborneo.moca.series.SeriesViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

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