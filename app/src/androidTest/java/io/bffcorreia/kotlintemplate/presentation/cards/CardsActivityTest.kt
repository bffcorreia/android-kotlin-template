package io.bffcorreia.kotlintemplate.presentation.cards

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import io.bffcorreia.kotlintemplate.AssertCurrentActivity.assertCurrentActivity
import io.bffcorreia.kotlintemplate.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CardsActivityTest {

  @Rule
  @JvmField
  val activityRule = ActivityTestRule<CardsActivity>(CardsActivity::class.java)

  @Test
  fun testActivityStarted() {
    assertCurrentActivity(CardsActivity::class.java)
  }

  @Test
  fun testTitle() {
    onView(withText(R.string.app_name)).check(matches(isDisplayed()))
  }

  @Test
  fun testCards() {
    val cards = "[Card(name=Chuck), Card(name=Narrator), Card(name=Tyler), Card(name=Marla)]"
    onView(withText(cards)).check(matches(isDisplayed()))
  }
}
