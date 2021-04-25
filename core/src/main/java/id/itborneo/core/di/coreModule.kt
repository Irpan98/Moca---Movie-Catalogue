package id.itborneo.core.di

import id.itborneo.core.data.MocaRepository
import id.itborneo.core.data.local.LocalDataSource
import id.itborneo.core.data.local.database.AppDatabase
import id.itborneo.core.data.remote.RemoteDataSource
import id.itborneo.core.domain.repository.IMocaRepository
import id.itborneo.core.domain.usecase.MocaInteractor
import id.itborneo.core.domain.usecase.MocaUseCase
import id.itborneo.core.networks.ApiConfig
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single {
        AppDatabase.getInstance(androidContext())
    }

    single { get<AppDatabase>().favoriteDao() }

}

val apiModule = module {

    single {
        ApiConfig.apiService
    }
}


val repositoryModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
    single {
        MocaRepository(get(), get())
    }
}

val useCaseModule = module {
    single<IMocaRepository> {
        MocaRepository(get(), get())
    }

    single<MocaUseCase> {
        MocaInteractor(get())
    }
}