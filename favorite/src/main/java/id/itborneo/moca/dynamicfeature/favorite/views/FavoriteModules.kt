package id.itborneo.moca.dynamicfeature.favorite.views

import id.itborneo.moca.dynamicfeature.favorite.viewmodels.FavoriteMovieViewModel
import id.itborneo.moca.dynamicfeature.favorite.viewmodels.FavoriteSeriesViewModel
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

