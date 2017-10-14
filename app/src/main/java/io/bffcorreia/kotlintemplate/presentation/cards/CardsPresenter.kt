package io.bffcorreia.kotlintemplate.presentation.cards

import io.bffcorreia.kotlintemplate.common.di.PerActivity
import io.bffcorreia.kotlintemplate.data.Card
import io.bffcorreia.kotlintemplate.domain.GetCards
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber
import javax.inject.Inject

@PerActivity class CardsPresenter
@Inject constructor(private val getCards: GetCards) : CardsContract.Presenter {

  private lateinit var view: CardsContract.View
  private val disposables = CompositeDisposable()

  override fun start(view: CardsContract.View) {
    this.view = view
    initView()
  }

  override fun stop() {
    if (!disposables.isDisposed) {
      disposables.dispose()
    }
  }

  private fun initView() {
    val disposable = getCards.observable().subscribe(
        { cards -> onCardsReceived(cards) },
        { error -> Timber.e(error) }
    )
    disposables.add(disposable)
  }

  private fun onCardsReceived(cards: List<Card>) {
    if (cards.isNotEmpty()) {
      view.showCards(cards.toString())
    }
  }
}
