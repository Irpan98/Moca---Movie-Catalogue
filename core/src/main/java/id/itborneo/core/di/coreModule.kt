package id.itborneo.core.di

import androidx.room.Room
import id.itborneo.core.data.MocaRepository
import id.itborneo.core.data.local.LocalDataSource
import id.itborneo.core.data.local.database.AppDatabase
import id.itborneo.core.data.remote.RemoteDataSource
import id.itborneo.core.domain.repository.IMocaRepository
import id.itborneo.core.domain.usecase.MocaInteractor
import id.itborneo.core.domain.usecase.MocaUseCase
import id.itborneo.core.networks.ApiConfig
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    val tableName = "db_favorite"

    single { get<AppDatabase>().favoriteDao() }

    single {
        val passphrase: ByteArray = SQLiteDatabase.getBytes("moca".toCharArray())
        val factory = SupportFactory(passphrase)

        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java, tableName
        ).fallbackToDestructiveMigration()
            .openHelperFactory(factory)
            .build()
    }
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