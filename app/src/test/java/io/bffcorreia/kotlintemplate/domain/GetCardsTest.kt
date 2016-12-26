package io.bffcorreia.kotlintemplate.domain

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import io.bffcorreia.kotlintemplate.CardFactory
import io.bffcorreia.kotlintemplate.data.CardRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import rx.Observable
import rx.schedulers.Schedulers

class GetCardsTest {

  val cardRepository = mock<CardRepository>()
  lateinit var getCards: GetCards
  lateinit var cardFactory: CardFactory

  @Before fun setup() {
    getCards = GetCards(cardRepository, Schedulers.immediate(), Schedulers.immediate())
    cardFactory = CardFactory()
  }

  @Test fun testGetCards() {
    val cards = cardFactory.buildList()
    whenever(cardRepository.getCards()).thenReturn(Observable.just(cards))
    val returnedCards = getCards.observable().toBlocking().first()
    assertThat(cards).isEqualTo(returnedCards)
  }
}
