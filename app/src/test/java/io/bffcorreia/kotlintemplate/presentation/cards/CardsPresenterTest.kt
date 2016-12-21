package io.bffcorreia.kotlintemplate.presentation.cards

import com.nhaarman.mockito_kotlin.*
import io.bffcorreia.kotlintemplate.CardFactory
import io.bffcorreia.kotlintemplate.data.Card
import io.bffcorreia.kotlintemplate.data.CardRepository
import io.bffcorreia.kotlintemplate.domain.GetCards
import org.junit.Before
import org.junit.Test
import rx.Observable
import rx.schedulers.Schedulers
import java.util.*

class CardsPresenterTest {

  val cardRepository = mock<CardRepository>()
  val view = mock<CardsContract.View>()
  lateinit var getCards: GetCards
  lateinit var presenter: CardsPresenter
  lateinit var cardFactory: CardFactory

  @Before fun setup() {
    getCards = GetCards(cardRepository, Schedulers.immediate(), Schedulers.immediate())
    presenter = CardsPresenter(getCards)
    cardFactory = CardFactory()
  }

  @Test fun onGetAllCardsShowCards() {
    val cards = cardFactory.buildList()
    whenever(cardRepository.getCards()).thenReturn(Observable.just(cards))
    presenter.start(view)
    verify(view).showCards(eq(cards.toString()))
  }

  @Test fun onGetAllCardsDoesNotShowCardsIfEmpty() {
    val cards = Collections.emptyList<Card>()
    whenever(cardRepository.getCards()).thenReturn(Observable.just(cards))
    presenter.start(view)
    verify(view, never()).showCards(any<String>())
  }
}
