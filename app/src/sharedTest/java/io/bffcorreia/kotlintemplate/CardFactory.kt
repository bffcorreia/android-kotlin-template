package io.bffcorreia.kotlintemplate

import io.bffcorreia.kotlintemplate.data.Card

class CardFactory : BaseFactory<Card>() {

  override fun build(): Card {
    return Card(faker.name.name())
  }
}
