package io.bffcorreia.spontaneousevents.common.di

import android.view.View
import dagger.Module
import dagger.Provides

@Module class ViewModule(private val view: View) {

  @Provides @PerView internal fun view(): View {
    return this.view
  }
}
