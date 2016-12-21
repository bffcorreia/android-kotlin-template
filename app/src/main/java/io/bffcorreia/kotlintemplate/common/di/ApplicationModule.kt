package io.bffcorreia.spontaneousevents.common.di

import android.content.Context
import dagger.Module
import dagger.Provides
import io.bffcorreia.spontaneousevents.common.AndroidApplication
import io.bffcorreia.spontaneousevents.domain.Executor
import rx.Scheduler
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Named
import javax.inject.Singleton

@Module class ApplicationModule(private val application: AndroidApplication) {

  @Provides @Singleton internal fun provideApplicationContext(): Context {
    return application
  }

  @Provides @Singleton @Named(Executor.MAIN) internal fun provideMainScheduler(): Scheduler {
    return AndroidSchedulers.mainThread()
  }

  @Provides @Singleton @Named(Executor.NEW) internal fun provideNewThreadScheduler(): Scheduler {
    return Schedulers.newThread()
  }

  @Provides @Singleton @Named(Executor.IO) internal fun provideIoScheduler(): Scheduler {
    return Schedulers.io()
  }
}
