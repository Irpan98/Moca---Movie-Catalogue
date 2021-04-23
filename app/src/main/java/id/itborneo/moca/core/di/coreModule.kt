package id.itborneo.moca.core.di

import id.itborneo.moca.core.data.MocaRepository
import id.itborneo.moca.core.data.local.LocalDataSource
import id.itborneo.moca.core.data.remote.RemoteDataSource
import id.itborneo.moca.core.domain.repository.IMocaRepository
import id.itborneo.moca.core.domain.usecase.MocaInteractor
import id.itborneo.moca.core.domain.usecase.MocaUseCase
import id.itborneo.moca.core.data.local.database.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single {
        AppDatabase.getInstance(androidContext())
    }

    single { get<AppDatabase>().favoriteDao() }

}


val repositoryModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource() }
    single {
        MocaRepository(get(), get())
    }
}

val useCaseModule = module {
    single<IMocaRepository> {
        MocaRepository(get(),get())
    }

    single<MocaUseCase> {
        MocaInteractor(get())
    }
}