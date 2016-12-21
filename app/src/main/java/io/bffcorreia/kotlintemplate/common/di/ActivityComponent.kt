package io.bffcorreia.spontaneousevents.common.di

import dagger.Subcomponent
import io.bffcorreia.kotlintemplate.CardsActivity

@PerActivity @Subcomponent(modules = arrayOf(ActivityModule::class)) interface ActivityComponent {

  fun plus(viewModule: ViewModule): ViewComponent

  fun inject(cardsActivity: CardsActivity)
}
