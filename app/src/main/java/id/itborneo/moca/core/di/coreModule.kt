package id.itborneo.moca.core.di

import id.itborneo.moca.core.local.AppDatabase
import id.itborneo.moca.core.repository.MocaRepository
import id.itborneo.moca.core.source.LocalDataSource
import id.itborneo.moca.core.source.RemoteDataSource
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