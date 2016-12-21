package io.bffcorreia.kotlintemplate.common

import android.app.Application
import io.bffcorreia.kotlintemplate.BuildConfig
import io.bffcorreia.kotlintemplate.common.di.ApplicationComponent
import io.bffcorreia.kotlintemplate.common.di.ApplicationModule
import io.bffcorreia.kotlintemplate.common.di.DaggerApplicationComponent
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