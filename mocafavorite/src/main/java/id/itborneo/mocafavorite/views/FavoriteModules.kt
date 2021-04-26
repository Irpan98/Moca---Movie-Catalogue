package id.itborneo.mocafavorite.views

import id.itborneo.mocafavorite.viewmodels.FavoriteMovieViewModel
import id.itborneo.mocafavorite.viewmodels.FavoriteSeriesViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val FavoriteModules = module {
    viewModel {
        FavoriteMovieViewModel(get())
    }
    viewModel {
        FavoriteSeriesViewModel(get())
    }
}

