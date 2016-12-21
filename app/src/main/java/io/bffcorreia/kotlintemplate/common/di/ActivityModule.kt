package io.bffcorreia.kotlintemplate.common.di

import android.app.Activity
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module class ActivityModule(private val activity: Activity) {

  @Provides @PerActivity @Named("activity_context") internal fun provideActivityContext(): Context {
    return this.activity
  }

  @Provides @PerActivity internal fun provideActivity(): Activity {
    return this.activity
  }
}
