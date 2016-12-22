package io.bffcorreia.kotlintemplate

import io.bloco.faker.Faker
import java.util.*

abstract class BaseFactory<out T> {

  private val DEFAULT_LIST_SIZE = 3
  protected val faker = Faker()

  abstract fun build(): T

  fun buildList(): List<T> {
    return buildList(DEFAULT_LIST_SIZE)
  }

  fun buildList(size: Int): List<T> {
    val list = ArrayList<T>(DEFAULT_LIST_SIZE)
    for (i in 1..size) {
      list.add(build())
    }
    return list
  }
}

