package io.bffcorreia.kotlintemplate.common.di

import dagger.Subcomponent
import io.bffcorreia.kotlintemplate.presentation.cards.CardsActivity

@PerActivity @Subcomponent(modules = arrayOf(ActivityModule::class)) interface ActivityComponent {

  fun plus(viewModule: ViewModule): ViewComponent

  fun inject(cardsActivity: CardsActivity)
}
