package io.bffcorreia.kotlintemplate.domain

import io.bffcorreia.kotlintemplate.data.Card
import io.bffcorreia.kotlintemplate.data.CardRepository
import io.reactivex.Observable
import io.reactivex.Scheduler
import javax.inject.Inject
import javax.inject.Named

class GetCards
@Inject constructor(private val cardRepository: CardRepository,
    @Named(Executor.NEW) subscribeOn: Scheduler,
    @Named(Executor.MAIN) observeOn: Scheduler) : UseCase<List<Card>>(subscribeOn, observeOn) {

  override fun buildUseCaseObservable(): Observable<List<Card>> {
    return cardRepository.getCards()
  }
}
