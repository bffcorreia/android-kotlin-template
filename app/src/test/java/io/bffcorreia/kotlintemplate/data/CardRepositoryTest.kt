package io.bffcorreia.kotlintemplate.data

import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class CardRepositoryTest {

  private lateinit var cardRepository: CardRepository

  @Before fun setup() {
    cardRepository = CardRepository()
  }

  @Test fun getAllCards() {
    val cards = cardRepository.getCards().toBlocking().first()
    assertThat(cards.size).isEqualTo(4)
  }
}