package io.bffcorreia.kotlintemplate.data

import io.reactivex.Observable
import java.util.*
import javax.inject.Inject

class CardRepository @Inject constructor() {

  fun getCards(): Observable<List<Card>> {
    return Observable.fromArray(buildCards())
  }

  private fun buildCards(): List<Card> {
    val cards = ArrayList<Card>()
    cards.add(Card("Chuck"))
    cards.add(Card("Narrator"))
    cards.add(Card("Tyler"))
    cards.add(Card("Marla"))
    return cards
  }
}
