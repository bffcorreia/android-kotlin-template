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
    cards.add(Card("Bruno"))
    cards.add(Card("Sérgio"))
    cards.add(Card("Mário"))
    cards.add(Card("Claudia"))
    return cards
  }
}
