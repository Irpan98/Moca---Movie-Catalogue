package id.itborneo.moca.core.di

import id.itborneo.moca.core.repository.MocaRepository
import org.koin.dsl.module

val repositoryModule = module {

    single {
        MocaRepository()
    }
}