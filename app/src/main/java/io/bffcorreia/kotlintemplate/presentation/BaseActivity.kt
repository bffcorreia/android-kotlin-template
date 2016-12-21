package io.bffcorreia.kotlintemplate.presentation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import butterknife.ButterKnife
import io.bffcorreia.kotlintemplate.common.AndroidApplication
import io.bffcorreia.kotlintemplate.common.di.ActivityComponent
import io.bffcorreia.kotlintemplate.common.di.ActivityModule
import io.bffcorreia.kotlintemplate.common.di.ApplicationComponent

abstract class BaseActivity : AppCompatActivity() {

  lateinit var activityComponent: ActivityComponent

  private val applicationComponent: ApplicationComponent
    get() = (application as AndroidApplication).applicationComponent

  private val activityModule: ActivityModule
    get() = ActivityModule(this)

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(layoutRes)
    initActivityComponent()
    initializeInjector()
    ButterKnife.bind(this)
  }

  protected abstract val layoutRes: Int

  protected abstract fun initializeInjector()

  private fun initActivityComponent() {
    activityComponent = applicationComponent.plus(activityModule)
  }
}
