package io.bffcorreia.spontaneousevents.common.di

import dagger.Component
import javax.inject.Singleton

@Singleton @Component(modules = arrayOf(ApplicationModule::class)) interface ApplicationComponent {
  fun plus(activityModule: ActivityModule): ActivityComponent
}
