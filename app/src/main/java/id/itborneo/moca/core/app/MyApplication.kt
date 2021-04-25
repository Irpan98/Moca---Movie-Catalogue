package id.itborneo.moca.core.app

import android.app.Application
import androidx.annotation.Keep
import id.itborneo.moca.core.di.*
import kotlinx.coroutines.FlowPreview
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

@Keep
class MyApplication : Application() {
    @FlowPreview
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    repositoryModule,
                    databaseModule,
                    apiModule,
                    viewModelModule,
                    useCaseModule
                )
            )
        }
    }
}