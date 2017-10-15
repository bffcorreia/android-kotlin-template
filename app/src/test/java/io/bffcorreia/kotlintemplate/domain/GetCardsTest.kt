package io.bffcorreia.kotlintemplate.domain

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import io.bffcorreia.kotlintemplate.CardFactory
import io.bffcorreia.kotlintemplate.data.CardRepository
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class GetCardsTest {

  private val cardRepository = mock<CardRepository>()
  private lateinit var getCards: GetCards
  private lateinit var cardFactory: CardFactory

  @Before
  fun setup() {
    getCards = GetCards(cardRepository, Schedulers.trampoline(), Schedulers.trampoline())
    cardFactory = CardFactory()
  }

  @Test
  fun testGetCards() {
    val cards = cardFactory.buildList()
    whenever(cardRepository.getCards()).thenReturn(Observable.just(cards))
    val returnedCards = getCards.observable().blockingFirst()
    assertThat(cards).isEqualTo(returnedCards)
  }
}
