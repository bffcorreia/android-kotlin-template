package io.bffcorreia.kotlintemplate.presentation.cards

import android.os.Bundle
import io.bffcorreia.kotlintemplate.R
import io.bffcorreia.kotlintemplate.presentation.BaseActivity
import javax.inject.Inject

class CardsActivity(override val layoutRes: Int = R.layout.activity_cards) : BaseActivity() {

  @Inject lateinit var cardsPresenter: CardsPresenter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
  }

  override fun initializeInjector() {
    activityComponent.inject(this)
  }
}
