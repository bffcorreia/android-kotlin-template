package io.bffcorreia.kotlintemplate.presentation.cards

import io.bffcorreia.kotlintemplate.common.di.PerActivity
import io.bffcorreia.kotlintemplate.domain.GetCards
import rx.subscriptions.CompositeSubscription
import timber.log.Timber
import javax.inject.Inject

@PerActivity class CardsPresenter
@Inject constructor(private val getCards: GetCards) : CardsContract.Presenter {

  private lateinit var view: CardsContract.View
  private val subscriptions = CompositeSubscription()

  override fun start(view: CardsContract.View) {
    this.view = view
    initView()
  }

  override fun stop() {
    if (!subscriptions.isUnsubscribed) {
      subscriptions.unsubscribe()
    }
  }

  private fun initView() {
    val subscriber = getCards.observable().subscribe(
        { cards -> view.showCards(cards.toString()) },
        { error -> Timber.e(error) }
    )
    subscriptions.add(subscriber)
  }
}
