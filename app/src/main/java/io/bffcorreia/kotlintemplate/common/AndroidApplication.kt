package io.bffcorreia.spontaneousevents.common

import android.app.Application
import io.bffcorreia.kotlintemplate.BuildConfig
import io.bffcorreia.spontaneousevents.common.di.ApplicationComponent
import io.bffcorreia.spontaneousevents.common.di.ApplicationModule
import io.bffcorreia.spontaneousevents.common.di.DaggerApplicationComponent
import timber.log.Timber

class AndroidApplication : Application() {

  lateinit var applicationComponent: ApplicationComponent

  override fun onCreate() {
    super.onCreate()

    initApplicationComponent()

    if (BuildConfig.DEBUG) {
      Timber.plant(Timber.DebugTree())
    }
  }

  private fun initApplicationComponent() {
    this.applicationComponent = DaggerApplicationComponent.builder().applicationModule(
        ApplicationModule(this)).build()
  }
}