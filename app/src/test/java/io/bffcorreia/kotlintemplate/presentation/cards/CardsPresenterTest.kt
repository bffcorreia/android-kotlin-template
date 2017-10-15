package io.bffcorreia.kotlintemplate.presentation.cards

import com.nhaarman.mockito_kotlin.*
import io.bffcorreia.kotlintemplate.CardFactory
import io.bffcorreia.kotlintemplate.data.Card
import io.bffcorreia.kotlintemplate.data.CardRepository
import io.bffcorreia.kotlintemplate.domain.GetCards
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import java.util.*

class CardsPresenterTest {

  private val cardRepository = mock<CardRepository>()
  private val view = mock<CardsContract.View>()
  private lateinit var getCards: GetCards
  private lateinit var presenter: CardsPresenter
  private lateinit var cardFactory: CardFactory

  @Before
  fun setup() {
    getCards = GetCards(cardRepository, Schedulers.trampoline(), Schedulers.trampoline())
    presenter = CardsPresenter(getCards)
    cardFactory = CardFactory()
  }

  @Test
  fun onGetAllCardsShowCards() {
    val cards = cardFactory.buildList()
    whenever(cardRepository.getCards()).thenReturn(Observable.just(cards))
    presenter.start(view)
    verify(view).showCards(eq(cards.toString()))
  }

  @Test
  fun onGetAllCardsDoesNotShowCardsIfEmpty() {
    val cards = Collections.emptyList<Card>()
    whenever(cardRepository.getCards()).thenReturn(Observable.just(cards))
    presenter.start(view)
    verify(view, never()).showCards(anyString())
  }
}
