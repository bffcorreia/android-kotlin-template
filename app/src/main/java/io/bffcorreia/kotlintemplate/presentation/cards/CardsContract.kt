package io.bffcorreia.kotlintemplate.presentation.cards

class CardsContract {
  interface View {
    fun showCards(cards: String)
  }

  interface Presenter {
    fun start(view: View)

    fun stop()
  }
}