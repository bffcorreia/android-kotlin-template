package io.bffcorreia.kotlintemplate.data

import rx.Observable
import java.util.*
import javax.inject.Inject

open class CardRepository @Inject constructor() {

  open fun getCards(): Observable<List<Card>> {
    return Observable.from(buildCards()).toList()
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
